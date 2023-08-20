package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {
	
	public MemberDAO() {
		try { //드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		
		//statement 객체 생성
		String query = "INSERT INTO MEMBER(NAME, AGE, ADDR) VALUE(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());
		
		// 쿼리문 실행
		System.out.println(ps.executeUpdate() + "명 가입!");
		
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<MemberVO> memberList = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			memberList.add(new MemberVO(rs.getString("name"),rs.getInt("age"),rs.getString("addr")));
		}
	
		closeAll(rs, ps, conn);
		
		return memberList;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM MEMBER WHERE NAME=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);
		
		MemberVO vo = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}
		
		closeAll(rs, ps, conn);
		
		return vo;
	}

}
