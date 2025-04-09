package ItemService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ItemDAO;
import dto.ItemDTO;
import dto.UserDTO;

public class ItemWriteService {
	
	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		

		int fileSize = 1024 * 1024 * 100; //100mb
		String realPath = request.getServletContext().getRealPath("item/upload");
		System.out.println(realPath);
		
		//파일 저장이 이루어짐
		try {

			MultipartRequest multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());

			String itemId = multi.getParameter("itemId");
			String itemName = multi.getParameter("itemName");
			String itemContents = multi.getParameter("itemContents");
			String itemPrice = multi.getParameter("itemPrice");
			
			String itemMainImage = multi.getOriginalFileName("itemMainImage");
			String itemMainStoreImage = multi.getFilesystemName("itemMainImage");
			
			String image1 = multi.getOriginalFileName("image1");
			String image1Store = multi.getFilesystemName("image1");
			String image2 = multi.getOriginalFileName("image2");
			String image2Store = multi.getFilesystemName("image2");
			String image3 = multi.getOriginalFileName("image3");
			String image3Store = multi.getFilesystemName("image3");
			
			String itemDetailImage = image1 + "`" + image2 + "`"  + image3;
			String itemDetailStoreImage = image1Store + "`" + image2Store + "`"  + image3Store;
			
			//session으로 userId 가져오기
			HttpSession session = request.getSession();
			UserDTO auth = (UserDTO) session.getAttribute("auth");
			String userId = auth.getUserId();
			
			ItemDTO dto = new ItemDTO();
			
			dto.setItemId(itemId);
			dto.setUserId(userId);
			dto.setItemName(itemName);
			dto.setItemContents(itemContents);
			dto.setItemPrice(Integer.parseInt(itemPrice));
			dto.setItemMainImage(itemMainImage);
			dto.setItemMainStoreImage(itemMainStoreImage);
			dto.setItemDetailImage(itemDetailImage);
			dto.setItemDetailStoreImage(itemDetailStoreImage);
			
			ItemDAO dao = new ItemDAO();
			dao.itemInsert(dto);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
	}

}
