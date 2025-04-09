package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDAO {

	String jdbcURL; 
	String jdbcDriver;  
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public UserDAO() {
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

	//회원 등록
	public void userInsert(UserDTO dto) {

		con = getConnection();
		sql = " insert into users(user_id, user_name, user_pw, user_email"
				+ "					, user_phone, user_regist, user_birth  )"
				+ " values(?, ?, ?, ?, ?, sysdate, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserPw());
			pstmt.setString(4, dto.getUserEmail());
			pstmt.setString(5, dto.getUserPhone());
			pstmt.setString(6, dto.getUserBirth());

			int i = pstmt.executeUpdate();
			System.out.println( i + " 행이(가) 삽입되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//로그인
	public UserDTO loginSelectOne(String userId) {
		UserDTO dto = null;
		con = getConnection();
		sql = " select user_id, user_name, user_pw, user_email"
				+ " 	, user_phone, user_regist, user_birth"
				+ " from users"
				+ "	where user_id = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserId(rs.getString(1));
				dto.setUserName(rs.getString(2));
				dto.setUserPw(rs.getString(3));
				dto.setUserEmail(rs.getString(4));
				dto.setUserPhone(rs.getString(5));
				dto.setUserRegist(rs.getString(6));
				dto.setUserBirth(rs.getString(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	//내정보
	public UserDTO userSelectOne(String userId) {
		UserDTO dto = null;

		con = getConnection();
		sql = " select user_id, user_name, user_pw, user_email"
				+ " , user_phone, user_regist, user_birth"
				+ " from users"
				+ " where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new UserDTO();
				dto.setUserId(rs.getString(1));
				dto.setUserName(rs.getString(2));
				dto.setUserPw(rs.getString(3));
				dto.setUserEmail(rs.getString(4));
				dto.setUserPhone(rs.getString(5));
				dto.setUserRegist(rs.getString(6));
				dto.setUserBirth(rs.getString(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	//내정보수정
	public void userModify(UserDTO dto) {

		con = getConnection();
		sql = " update users"
				+ " set user_name = ?"
				+ "		, user_email = ? "
				+ "		, user_phone = ?"
				+ "		, user_birth = ?"
				+ " where user_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserName());
			pstmt.setString(2, dto.getUserEmail());
			pstmt.setString(3, dto.getUserPhone());
			pstmt.setString(4, dto.getUserBirth());
			pstmt.setString(5, dto.getUserId());
			
			int i = pstmt.executeUpdate();
			System.out.println( i + " 행이(가) 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원탈퇴
	public void userDelete(String userId) {

		con = getConnection();
		sql = " delete from users where user_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			int i = pstmt.executeUpdate();
			System.out.println(i+" 행이(가) 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
