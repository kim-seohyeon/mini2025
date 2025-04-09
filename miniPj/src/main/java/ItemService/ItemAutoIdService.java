package ItemService;

import javax.servlet.http.HttpServletRequest;

import dao.ItemDAO;

public class ItemAutoIdService {

	public void execute(HttpServletRequest request) {

		ItemDAO dao = new ItemDAO();
		String itemId = dao.selectAutoId();
		request.setAttribute("itemId", itemId);
	}
}
