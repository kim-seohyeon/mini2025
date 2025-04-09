package RentalInfoService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.WishDAO;
import dto.OwnerDTO;
import dto.UserDTO;

public class OwnerListService {

	public void execute(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		
		WishDAO dao = new WishDAO();
		List<OwnerDTO> list = dao.ownerSelectAll(auth.getUserId());
		request.setAttribute("list", list);
		
	}
}
