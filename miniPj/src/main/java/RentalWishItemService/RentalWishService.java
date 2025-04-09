package RentalWishItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.WishDAO;
import dto.UserDTO;
import dto.WishDTO;

public class RentalWishService {
	public void execute(HttpServletRequest request) {
		
		String itemId = request.getParameter("itemId");
		
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		
		String userId = null;
		
		if(auth != null) {
			UserDAO mdao = new UserDAO();
			UserDTO mdto = mdao.userSelectOne(auth.getUserId());
			userId = mdto.getUserId();
		}
		
		//찜 정보 저장
		WishDTO dto = new WishDTO();
		dto.setItemId(itemId);
		dto.setUserId(userId);
		
		//찜 정보 가져오기
		WishDAO dao = new WishDAO();
		dto = dao.wishSelectOne(dto);
		
		request.setAttribute("wish", dto);
		
	}
}
