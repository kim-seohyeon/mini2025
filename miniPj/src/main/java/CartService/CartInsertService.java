package CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ItemDAO;
import dao.UserDAO;
import dao.WishDAO;
import dto.CartDTO;
import dto.UserDTO;

public class CartInsertService {

	public void execute(HttpServletRequest request) {
	
		String  itemId = request.getParameter("itemId");
		String  cartQty = request.getParameter("cartQty");

		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		UserDAO mdao = new UserDAO();
		UserDTO mdto = mdao.userSelectOne(auth.getUserId());
		
		ItemDAO idao = new ItemDAO();
		String userId = idao.userIdSelectOne(itemId);
		
		System.out.println("userId : " + userId) ;
		
		
		CartDTO dto = new CartDTO();
		
		dto.setCartQty(Integer.parseInt(cartQty));
		dto.setItemId(itemId);
		dto.setUserId(userId);
		dto.setUserId2(mdto.getUserId());

		WishDAO dao = new WishDAO();
		dao.cartMerge(dto);
		
	}
	
}
