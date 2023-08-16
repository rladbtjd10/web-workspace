package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate {

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("Connection...");
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
	public ArrayList<Item> getAllItem() throws SQLException {
		
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ArrayList<Item> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Item item = new Item();
			item.setItemId(rs.getInt("itemId"));
			item.setItemName(rs.getString("itemName"));
			item.setPrice(rs.getInt("price"));
			item.setDescription(rs.getString("description"));
			item.setPictureUrl(rs.getString("pictureUrl"));
			item.setCount(rs.getInt("count"));
		}
		
		closeAll(rs, ps, conn);
		
		return list;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM ITEM WHERE ITEM_ID=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, itemId);
		
		Item item = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			item = new Item();
			item.setItemId(rs.getInt("itemId"));
			item.setItemName(rs.getString("itemName"));
			item.setPrice(rs.getInt("price"));
			item.setDescription(rs.getString("description"));
			item.setPictureUrl(rs.getString("pictureUrl"));
			item.setCount(rs.getInt("count"));
		}
		
		return null;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		String query = "UPDATE ITEM SET COUNT = ? WHERE ITEM_ID = ?";
		PreparedStatement st = conn.prepareStatement(query);
		
		int count = getItem(itemId).getCount();
		
		st.setInt(1, ++count);
		st.setInt(2, itemId);
		
		int result = st.executeUpdate();
		
		if(result == 1) {
			return true;
		}
		
		return false;
	}
	
}
