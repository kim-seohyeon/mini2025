package UserService;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import dto.UserDTO;

public class UserWriteService {

	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userRegist = request.getParameter("userRegist");
		String userBirth = request.getParameter("userBirth");
		
		UserDTO dto = new UserDTO();
						
		dto.setUserId(userId);
		dto.setUserName(userName);
		dto.setUserPw(userPw);
		dto.setUserEmail(userEmail);
		dto.setUserPhone(userPhone);
		dto.setUserRegist(userRegist);
		dto.setUserBirth(userBirth);
		
		UserDAO dao = new UserDAO();
		dao.userInsert(dto);
		
		
	}
}
