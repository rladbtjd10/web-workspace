package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	
	public UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sample", "sample");
		return conn;
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		ps.close();
		conn.close();
	}
	
	public UserDTO findByUser(int no) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM TB_USER WHERE USER_NO = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		
		ResultSet rs = ps.executeQuery();
		
		UserDTO user = null;
		
		if(rs.next()) {
			user = new UserDTO();
			user.setNo(no);
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
		}
		closeAll(rs, ps, conn);
		
		return user;
		
		
		
	}
	

}
