package CartService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.WishDAO;
import dto.CartListDTO;
import dto.UserDTO;

public class CartListService  {

	public void execute(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		
		UserDAO mdao = new UserDAO();
		UserDTO mdto = mdao.userSelectOne(auth.getUserId());
		
		WishDAO dao = new WishDAO();
		List<CartListDTO> list = dao.cartSelectAll(mdto.getUserId());
		
		System.out.println(list.size());
		request.setAttribute("list", list);
		
	}
}
