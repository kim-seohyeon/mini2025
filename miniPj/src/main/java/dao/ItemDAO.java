package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemDTO;

public class ItemDAO {

	//dao jdbc 복붙
	
	String jdbcURL; 
	String jdbcDriver;  
	protected Connection con;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	protected String sql;
	
	public ItemDAO() {
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
	
	//상품 등록
	public void itemInsert(ItemDTO dto) {
		
		con = getConnection();
		sql = " insert into items(item_id, user_id, item_name, item_contents"
				+ "				, item_price, item_regist, item_main_image, item_main_store_image"
				+ "				, item_detail_image, item_detail_store_image, item_update_date)"
				+ " values(?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getItemId());
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getItemName());
			pstmt.setString(4, dto.getItemContents());
			pstmt.setInt(5, dto.getItemPrice());
			pstmt.setString(6, dto.getItemMainImage());
			pstmt.setString(7, dto.getItemMainStoreImage());
			pstmt.setString(8, dto.getItemDetailImage());
			pstmt.setString(9, dto.getItemDetailStoreImage());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//상품 상세보기
	public List<ItemDTO> itemSelectAll() {
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		
		con = getConnection();
		sql = " select item_id, item_name, item_contents"
				+ "		, item_price, item_main_image, item_main_store_image"
				+ "		, item_detail_image, item_detail_store_image"
				+ " from items";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				
				dto.setItemId(rs.getString("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemContents(rs.getString("item_contents"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemMainImage(rs.getString("item_main_image"));
				dto.setItemMainStoreImage(rs.getString("item_main_store_image"));
				dto.setItemDetailImage(rs.getString("item_detail_image"));
				dto.setItemDetailStoreImage(rs.getString("item_detail_store_image"));

				
				list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	//상품 번호 자동부여
	public String selectAutoId() {
		String itemId = null;
		con = getConnection();
		sql = " select concat('item_', nvl(substr(max(item_id),6),10000)+1) "
				+ " from items"; 
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			itemId = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemId;
	}

	//상세보기
	public ItemDTO selectone(String itemId) {
		ItemDTO dto = null;
		
		con = getConnection();
		sql = " select item_id, user_id, item_name, item_contents"
				+ "	 , item_price, item_regist, item_main_image, item_main_store_image"
				+ "	 , item_detail_image, item_detail_store_image, item_update_date "
				+ " from items"
				+ " where item_id = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ItemDTO();
				dto.setItemId(rs.getNString("item_id"));
				dto.setUserId(rs.getString("user_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemContents(rs.getString("item_contents"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemRegist(rs.getDate("item_regist"));
				dto.setItemMainImage(rs.getString("item_main_image"));
				dto.setItemMainStoreImage(rs.getString("item_main_store_image"));
				dto.setItemDetailImage(rs.getString("item_detail_image"));
				dto.setItemDetailStoreImage(rs.getString("item_detail_store_image"));
				dto.setItemUpdateDate(rs.getDate("item_update_date"));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	//상품 수정
	public void itemUpdate(ItemDTO dto) {

		con = getConnection();
		sql = " update items"
				+ " set item_name = ?"
				+ "   , item_price = ? "
				+ "   , item_contents = ?"
				+ "   , item_update_date = sysdate"
				+ " where item_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getItemName());
			pstmt.setInt(2, dto.getItemPrice());
			pstmt.setString(3, dto.getItemContents());
			pstmt.setString(4, dto.getItemId());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//상품 삭제
	public int itemDelete(String itemId) {

		con = getConnection();
		sql = " delete from items where item_id = ?";
		int i = 0;
		try { //지역변수, 블록변수
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			
			i = pstmt.executeUpdate();
			System.out.println(i + " 행이(가) 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}

	public String userIdSelectOne(String itemId) {
		String userId = null;
		con = getConnection();
		sql = " select user_Id from items where item_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			rs = pstmt.executeQuery();
			if(rs.next())
				userId = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

}
