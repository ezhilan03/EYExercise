package EYExercise.day22.invoicejdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import EYExercise.day21.DBUtility;

public class ItemDetailsDAOImpl implements ItemDetailsDAO{
	Connection con;
	
	public ItemDetailsDAOImpl() {
		con = DBUtility.getConnection();
	}
	
	@Override
	public int insertItemDetails(ItemDetailsDTO itemDetailsDTO) {
		try {
			String query = "insert into item_details(item_no,item_desc,item_price,item_unit) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, itemDetailsDTO.getItemNo());
			st.setString(2, itemDetailsDTO.getItemDesc());
			st.setDouble(3, itemDetailsDTO.getItemPrice());
			st.setString(4,itemDetailsDTO.getItemUnit());
			
			int i = st.executeUpdate();
			con.commit();
			st.close();
			return i;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteItemDetails(int itemNo) {
		try {
			String query = "delete from item_details where item_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, itemNo);
			int i = st.executeUpdate();
			con.commit();
			st.close();
			return i;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int updateItemDetails(ItemDetailsDTO itemDetailsDTO,double itemPrice) {
		try {
			int itemNo = itemDetailsDTO.getItemNo();
			String query = "update item_details set item_price = ? where item_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setDouble(1, itemPrice);
			st.setInt(2, itemNo);
			int i = st.executeUpdate();
			con.commit();
			st.close();
			return i;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public ItemDetailsDTO getItemDetails(int itemNo) {
		try {
			String query = "select * from item_details where item_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, itemNo);
			ResultSet rs = st.executeQuery();
			ItemDetailsDTO itemDetails = null;
			if(rs.next()) {
				//int itemNo = rs.getInt("item_no");
				String itemDesc = rs.getString("item_desc");
				double itemPrice = rs.getDouble("item_price");
				String itemUnit = rs.getString("item_unit");
				
				itemDetails = new ItemDetailsDTO();
				itemDetails.setItemNo(itemNo);
				itemDetails.setItemDesc(itemDesc);
				itemDetails.setItemPrice(itemPrice);
				itemDetails.setItemUnit(itemUnit);
				
				return itemDetails;
			}
			return itemDetails;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Set<ItemDetailsDTO> getItemDetailsAll() {
		Set<ItemDetailsDTO> set = new HashSet<ItemDetailsDTO>();
		try {
			String query = "select * from item_details ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				int itemNo = rs.getInt("item_no");
				String itemDesc = rs.getString("item_desc");
				double itemPrice = rs.getDouble("item_price");
				String itemUnit = rs.getString("item_unit");
				
				ItemDetailsDTO itemDetails = new ItemDetailsDTO();
				itemDetails.setItemNo(itemNo);
				itemDetails.setItemDesc(itemDesc);
				itemDetails.setItemPrice(itemPrice);
				itemDetails.setItemUnit(itemUnit);
				
				set.add(itemDetails);
			}
			return set;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		DBUtility.closeConnection(null);
	}
}
