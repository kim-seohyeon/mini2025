package RentalWishItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.WishDAO;
import dto.UserDTO;
import dto.WishDTO;

public class RentalWishItemService {
	public void execute(HttpServletRequest request) {
		
		String itemId = request.getParameter("itemId");
		
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
	
		UserDAO mdao = new UserDAO();
		UserDTO mdto = mdao.userSelectOne(auth.getUserId());
		
		WishDTO dto = new WishDTO();
		dto.setUserId2(mdto.getUserId());
		dto.setItemId(itemId);
		
		//wish 테이블에 데이터 넣기
		WishDAO dao = new WishDAO();
		dao.wishInsert(dto);
	}

}
