package ItemService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;
import dto.ItemDTO;

public class ItemUpdateService {

	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}

		String itemId = request.getParameter("itemId");
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemContents = request.getParameter("itemContents");
		
		ItemDTO dto = new ItemDTO();
		
		dto.setItemId(itemId);
		dto.setItemName(itemName);
		dto.setItemPrice(Integer.parseInt(itemPrice));
		dto.setItemContents(itemContents);
		
		ItemDAO dao = new ItemDAO();
		dao.itemUpdate(dto);
		
	}
}
