package ItemRentalService;

import javax.servlet.http.HttpServletRequest;

import dao.WishDAO;

public class ReturnService {
	public void execute(HttpServletRequest request) {
		String rentalId = request.getParameter("rentalId");
		String itemId = request.getParameter("itemId"); 
		
		WishDAO dao = new WishDAO();
		dao.returnState(rentalId, itemId);
	}
}
