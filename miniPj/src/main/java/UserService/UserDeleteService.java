package UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

public class UserDeleteService {
	public void execute(HttpServletRequest request) {

		String userId = request.getParameter("userId");
		
		UserDAO dao = new UserDAO();
		dao.userDelete(userId);
		
	}
}
