package UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dto.UserDTO;

public class LoginService extends HttpServlet{

	public int execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 서비스");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		UserDAO dao = new UserDAO();
		UserDTO dto = dao.loginSelectOne(userId);
		
		//로그인 알고리즘
		int i = 0;
		if(dto == null) { //사용자 아이디가 존재하지 않은 경우
			request.setAttribute("idErr", "아이디가 존재하지 않습니다.");
		}else { //아이디가 존재하는 경우
			if(userPw.equals(dto.getUserPw())) { //비밀번호도 일치하는 경우
				HttpSession session = request.getSession();
				session.setAttribute("auth", dto);				
				i = 1;
			}else{ //비밀번호가 일치하지 않는 경우
				request.setAttribute("pwErr", "비밀번호가 틀렸습니다.");
				
			}
		}
		return i;
	}
}
