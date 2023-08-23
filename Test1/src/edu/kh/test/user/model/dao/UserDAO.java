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
			Class.forName("ServerInfo.DRIVER_NAME");
		} catch (ClassNotFoundException e) {}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection("ServerInfo.URL", "ServerInfo.USER", "ServerInfo.PASSWORD");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		rs.close();
	}
	
	public UserDTO findByUser(int no) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM TB_USER WHERE USER_NO = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		
		ResultSet rs = ps.executeQuery();
		
		UserDTO user = null;
		
		if(rs.next()) {
			user = new UserDTO(rs.getInt("no"), rs.getString("id"), rs.getString("name"), rs.getInt("age"));
		}
		
		return user;
		
	}
	

}
