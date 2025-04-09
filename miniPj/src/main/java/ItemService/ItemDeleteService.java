package ItemService;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;
import dto.ItemDTO;

public class ItemDeleteService {
	public void execute(HttpServletRequest request) {
		String itemId = request.getParameter("itemId");
		ItemDAO dao = new ItemDAO();
		
		//파일 정보를 가져오기 위해 상품번호에 해당하는 정보들을 가지고 옴
		ItemDTO dto = dao.selectone(itemId);
		int i = dao.itemDelete(itemId);
		
		if(i > 0) {
			String realPath = request.getServletContext().getRealPath("goods/upload");
			String mainImage = dto.getItemMainStoreImage();
			//파일 삭제 코드
			File file = new File(realPath + "/" + mainImage);
			if(file.exists()) file.delete();
			//split()을 하면 반환되는 것은 배열이다.
			String images[] = dto.getItemDetailStoreImage().split("`");
			//forEach
			for(String image : images) {
				file = new File(realPath + "/" + image);
				if(file.exists()) file.delete();	
			}
		}
	}

}
