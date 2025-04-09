package UserService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.UserDTO;

public class UserUpdateService {
	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		String userBirth = request.getParameter("userBirth");
		String userPw = request.getParameter("userPw");

		UserDTO dto = new UserDTO();
		
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPhone(userPhone);
		dto.setUserEmail(userEmail);
		dto.setUserBirth(userBirth);
		dto.setUserPw(userPw);
		
		UserDAO dao = new UserDAO();
		dao.userModify(dto);
		
//		int i;
//		HttpSession session = request.getSession();
//		UserDTO auth = (UserDTO) session.getAttribute("auth");
//		
//		if(userPw.equals(auth.getUserPw())) {
//			UserDAO dao = new UserDAO();
//			dao.userModify(dto);
//			i = 1;
//		}else {
//			request.setAttribute("pwErr", "비밀번호가 일치하지 않습니다.");			
//			i = 0;
//		}
		
	}
}
