package ItemService;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;
import dto.ItemDTO;

public class ItemDetailService {
	public void execute(HttpServletRequest request) {
		String itemId = request.getParameter("itemId");
		ItemDAO dao = new ItemDAO();
		ItemDTO dto = dao.selectone(itemId);
		request.setAttribute("dto", dto);
	}
}
