package ItemRentalService;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.WishDAO;
import dto.RentalDTO;
import dto.UserDTO;

public class ItemRentalsService {
	public void execute(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		
		String itemsTotalPrice = request.getParameter("itemsTotalPrice");

		RentalDTO dto = new RentalDTO();
		dto.setItemsTotalPrice(Integer.parseInt(itemsTotalPrice));
		
		//회원 대여정보
		HttpSession session = request.getSession();
		UserDTO auth = (UserDTO) session.getAttribute("auth");
		
		dto.setUserId(auth.getUserId());
		
		//대여번호 만들기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rentalId = sdf.format(new Date());
		dto.setRentalId(rentalId);
		
		WishDAO dao = new WishDAO();
		
		dao.rentalInsert(dto);
		
		//대여상품리스트
		String itemIds[]= request.getParameter("itemId").split("`");
		for(String itemId : itemIds) {
			dao.rentalItemListInsert(itemId, rentalId, dto.getUserId());
			dao.cartDelete(itemId, dto.getUserId());
		}
		
		
	}
}
