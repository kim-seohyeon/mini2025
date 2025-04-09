package ItemService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;
import dto.ItemDTO;

public class ItemListService {
	public void excute(HttpServletRequest request) {
		
		ItemDAO dao = new ItemDAO();
		List<ItemDTO> list = dao.itemSelectAll();
		request.setAttribute("list", list);
		
	}
}
