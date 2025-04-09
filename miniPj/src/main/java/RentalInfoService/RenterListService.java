package RentalInfoService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.WishDAO;
import dto.RenterDTO;
import dto.UserDTO;

public class RenterListService {
	public void execute(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		
		WishDAO dao = new WishDAO();
		List<RenterDTO> list = dao.rentalSelectAll(auth.getUserId());
		request.setAttribute("list", list);
	
	}
}
