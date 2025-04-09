package ItemRentalService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.WishDAO;
import dto.CartListDTO;

public class ItemRentalService {
	public void execute(HttpServletRequest request){
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		String [] itemIds = request.getParameterValues("prodCk");
		
		WishDAO dao = new WishDAO();
		Integer itemsTotalPrice = 0;
		String nums = "";
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		for(String itemId : itemIds) {
			CartListDTO dto = dao.cartSelectOne(itemId);
			itemsTotalPrice += dto.getItemPrice() * dto.getCartQty();
			nums += itemId +"`";
			list.add(dto);
		}
		request.setAttribute("list", list);
		request.setAttribute("itemsTotalPrice", itemsTotalPrice);
		request.setAttribute("nums", nums);
		
	}
}
