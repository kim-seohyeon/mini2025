package UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.UserDTO;

public class UserDetailService {
	public void execute(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserDTO udto = (UserDTO) session.getAttribute("auth");
		
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.userSelectOne(udto.getUserId());
		request.setAttribute("dto", dto);
		
	}

}
