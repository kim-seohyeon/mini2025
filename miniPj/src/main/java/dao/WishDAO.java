package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartDTO;
import dto.CartListDTO;
import dto.OwnerDTO;
import dto.RentalDTO;
import dto.RenterDTO;
import dto.WishDTO;

public class WishDAO {
	
	String jdbcURL; 
	String jdbcDriver;  
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public WishDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	
	public Connection getConnection() {
		Connection co = null;
		try{
			Class.forName(jdbcDriver);
			co = DriverManager.getConnection(jdbcURL, "mini", "1234");
			}catch(Exception e) {
				e.printStackTrace();
			}
		return co;
	}

	public void wishInsert(WishDTO dto) {
		
		con = getConnection();
		sql = " merge into wishlist w "
			+ " using(select USER_ID, item_id from items where item_id=?) i"
			+ " on (w.item_id = i.item_id and w.user_id2=?) "
			+ " when matched then "
			+ "		update set wish_date = sysdate "
			+ "		delete where item_id = ? and user_id2=?"
			+ " when not matched then "
			+ "		insert(USER_ID, user_id2, item_id, wish_date)"
			+ "		values(i.USER_ID, ?, i.item_id, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getItemId());
			pstmt.setString(2, dto.getUserId2());
			pstmt.setString(3, dto.getItemId());
			pstmt.setString(4, dto.getUserId2());
			pstmt.setString(5, dto.getUserId2());

			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 병합되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public WishDTO wishSelectOne(WishDTO dto) {
		WishDTO wdto = null;
		con = getConnection();
		sql = " select * from wishlist where item_id = ? and user_id = ? ";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getItemId());
			pstmt.setString(2, dto.getUserId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				wdto = new WishDTO();
				wdto.setItemId(rs.getString("item_id"));
				wdto.setUserId(rs.getString("user_id"));
				wdto.setWishDate(rs.getString("wish_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wdto;
	}

	public void cartMerge(CartDTO dto) {
		System.out.println(dto.getItemId());
		con = getConnection();
		sql = " merge into cart  c"
			+ " using(select item_id from items where item_id = ?)  i"
			+ " on (c.item_id = i.item_id and c.user_id2 = ? )"
			+ " when matched then "
			+ " update set cart_qty = cart_qty + ? "
			+ " when not matched then "
			+ " insert(user_id, item_id,  user_id2, cart_date, cart_qty) "
			+ " values(?, i.item_id, ?, sysdate, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getItemId());
			pstmt.setString(2, dto.getUserId2());
			pstmt.setInt(3, dto.getCartQty());
			pstmt.setString(4, dto.getUserId());
			pstmt.setString(5, dto.getUserId2());
			pstmt.setInt(6, dto.getCartQty());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 병합되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<CartListDTO> cartSelectAll(String userId) {
		List<CartListDTO> list = new ArrayList<CartListDTO>()	;
		con = getConnection();
		
		sql = " select i.item_id, item_name, item_price, item_main_store_image"
				+ "		, c.user_id2, cart_qty, cart_date"
				+ "		, cart_qty * item_price as items_total_price"
				+ " from items i join cart c"
				+ "	on i.item_id = c.item_id "
				+ " where c.user_id2 = ? "; 
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setItemId(rs.getString("item_id"));
				dto.setCartDate(rs.getString("cart_date"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setItemImage(rs.getString("item_main_store_image"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setUserId(rs.getString("user_id2"));
				dto.setItemsTotalPrice(rs.getInt("items_total_price"));

				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	public CartListDTO cartSelectOne(String itemId) {
		CartListDTO dto = null;
		con = getConnection();
		
		sql = " select i.item_id, item_name, item_price, item_main_store_image"
				+ "		, c.user_id2, cart_qty, cart_date"
				+ "		, cart_qty * item_price as items_total_price"
				+ " from items i join cart c"
				+ "	on i.item_id = c.item_id "
				+ " where c.item_Id = ? "; 
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new CartListDTO();
				dto.setItemId(rs.getString("item_id"));
				dto.setCartDate(rs.getString("cart_date"));
				dto.setCartQty(rs.getInt("cart_qty"));
				dto.setItemImage(rs.getString("item_main_store_image"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setUserId(rs.getString("user_id2"));
				dto.setItemsTotalPrice(rs.getInt("items_total_price"));


			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void rentalInsert(RentalDTO dto) {

		con = getConnection();
		sql = " insert into rentals(rental_id, user_id, items_total_price)"
				+ " values(?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getRentalId());
			pstmt.setString(2, dto.getUserId());
			pstmt.setInt(3, dto.getItemsTotalPrice());

			int i = pstmt.executeUpdate();
			System.out.println( i + " 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void rentalItemListInsert(String itemId, String rentalId, String userId) {
		
		con = getConnection();
		sql = " insert into Rental_Items(rental_id, user_id, item_id, rental_start, rental_end, item_rental_price, item_qty) "
				+ " select ?, i.user_id, i.item_id, sysdate, null, cart_qty * item_price, cart_qty "
				+ " from cart c join items i "
				+ " on c.item_id = i.item_id "
				+ " where i.item_id = ? and user_id2 = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rentalId);
			pstmt.setString(2, itemId);
			pstmt.setString(3, userId);
			
			int i = pstmt.executeUpdate();
			
			System.out.println( i + " 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void cartDelete(String itemId, String userId) {
		
		con = getConnection();
		sql = " delete from cart "
				+ " where item_id = ? and user_id2 = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			pstmt.setString(2, userId);
			
			int i = pstmt.executeUpdate();
			System.out.println( i + " 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public List<RenterDTO> rentalSelectAll(String userId) {
		List<RenterDTO> list = new ArrayList<RenterDTO>()	;
		con = getConnection();
		
		sql = " select r.rental_id, r.user_id"
				+ "	 , ri.rental_date, rental_start, rental_end , item_Rental_Price"
				+ "  , i.item_id, i.item_name,i.item_price, item_qty"
				+ " from rental_items ri join rentals r "
				+ " on ri.rental_id = r.rental_id join items i "
				+ " on i.item_id = ri.item_id "
				+ " where i.user_id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				RenterDTO dto = new RenterDTO();
				dto.setRentalId(rs.getString("rental_id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setRentalDate(rs.getDate("rental_date"));
				dto.setRentalStart(rs.getDate("rental_start"));
				dto.setRentalEnd(rs.getDate("rental_end"));
				dto.setItemRentalPrice(rs.getInt("item_Rental_Price"));
				dto.setItemId(rs.getString("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPice(rs.getInt("item_price"));
				dto.setItemQty(rs.getInt("item_qty"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<OwnerDTO> ownerSelectAll(String userId) {
		List<OwnerDTO> list = new ArrayList<OwnerDTO>()	;
		con = getConnection();
		
		sql = " select i.user_id, i.item_name, i.item_id "
				+ "	 , ri.rental_date, rental_start, rental_end , item_Rental_Price, ri.item_qty"
				+ "  , r.user_id, r.rental_id "
				+ " from rental_items ri join items i "
				+ " on i.item_id = ri.item_id join rentals r "
				+ " on ri.RENTAL_ID = r.RENTAL_ID"
				+ " where r.user_id = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				OwnerDTO dto = new OwnerDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemQty(rs.getInt("item_qty"));
				dto.setRentalDate(rs.getDate("rental_date"));
				dto.setRentalStart(rs.getDate("rental_start"));
				dto.setRentalEnd(rs.getDate("rental_end"));
				dto.setItemRentalPrice(rs.getInt("item_Rental_Price"));
				dto.setRentalId(rs.getString("rental_id"));
				dto.setItemId(rs.getString("item_id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;	
	}
	public void returnState(String rentalId,String itemId) {
		con = getConnection();
		sql = " update rental_items "
			+ " set RENTAL_END = sysdate "
			+ " where rental_Id = ? and item_Id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rentalId);
			pstmt.setString(2, itemId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}












