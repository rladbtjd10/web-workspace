package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

public class MemberRepository implements MemberDAOTemplate {
	//DAO랑 명칭차이지 틀린게 없음 시험때문에 하는것
	//상호작용을 중재하는 역할을 하기때문에 DAO랑 달리 드라이버로딩은 넣지 않음

		@Override
		public Connection getConnection() throws SQLException {
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
		public void registerMember(MemberDTO dto) throws SQLException {
			Connection conn = getConnection();

			String query = "INSERT INTO member(id, password, name, address) VALUES(?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddress());
			
			ps.executeUpdate();
			
			closeAll(ps, conn);
		}

		@Override
		public MemberDTO login(String id, String password) throws SQLException {

			Connection conn = getConnection();
			
			String query = "SELECT* FROM member WHERE id=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			MemberDTO dto = null;
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
			closeAll(rs, ps, conn);
			return dto;
			
		}

		@Override
		public MemberDTO findByIdMember(String id) throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM MEMBER WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			MemberDTO dto = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
			
			closeAll(rs, ps, conn);

			return dto;
		}

		@Override
		public ArrayList<MemberDTO> showAllMember() throws SQLException {

			Connection conn = getConnection();
			
			String query = "SELECT * FROM MEMBER";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ArrayList<MemberDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
//				list.add(new MemberDTO(rs.getString("id"),rs.getString("password"),rs.getInt("name"), rs.getString("address"))); //setter,getter만 생성되서 이형태는 안됨!! 밑에 처럼 해줘야됨~
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				list.add(dto);
			}
			
			closeAll(rs, ps, conn);

			return list;
		}
		
		public void updateMember(MemberDTO dto) throws SQLException {
			Connection conn = getConnection();
			
			String query = "UPDATE member SET password=?, name=?, address=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getPassword());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getId());
			
			ps.executeQuery();
			closeAll(ps, conn);
			
		}

}
