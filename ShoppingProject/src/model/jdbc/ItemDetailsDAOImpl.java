package model.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import model.DBUtility;

public class ItemDetailsDAOImpl implements ItemDetailsDAO,Cloneable{
	private Properties prop;
	private static ItemDetailsDAOImpl itemDetailsDAOImpl;
	
	private ItemDetailsDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static ItemDetailsDAOImpl getItemDetailsDAOImpl(Properties prop) {
		if(itemDetailsDAOImpl==null) {
			itemDetailsDAOImpl = new ItemDetailsDAOImpl(prop);
			return itemDetailsDAOImpl;
		}
		else {
			return itemDetailsDAOImpl.createClone();
		}
	}
	
	public ItemDetailsDAOImpl createClone() {
		try {
			return (ItemDetailsDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertItemDetails(ItemDetailsDTO itemDetailsDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("insert into item_details values(?,?,?,?,?,?)");
			st.setInt(1, itemDetailsDTO.getItemNo());
			st.setInt(2, itemDetailsDTO.getCategoryID());
			st.setString(3, itemDetailsDTO.getItemDesc());
			st.setDouble(4, itemDetailsDTO.getItemPrice());
			st.setString(5,itemDetailsDTO.getItemUnit());
			st.setString(6,itemDetailsDTO.getCategoryName());
			
			int count = st.executeUpdate();
			con.commit();
			DBUtility.closeConnection(null);
			return count;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public ItemDetailsDTO getItemDetails(int itemNo) {
		try {
			ItemDetailsDTO itemDetailsDTO = ItemDetailsDTO.getItemDetailsDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("Select * from item_details where item_no=?");
			st.setInt(1, itemNo);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				itemDetailsDTO.setItemNo(itemNo);
				itemDetailsDTO.setCategoryID(rs.getInt("category_id"));
				itemDetailsDTO.setItemDesc(rs.getString("item_desc"));
				itemDetailsDTO.setItemPrice(rs.getDouble("item_price"));
				itemDetailsDTO.setItemUnit(rs.getString("item_unit"));
				itemDetailsDTO.setCategoryName(rs.getString("category_name"));
			}
			DBUtility.closeConnection(null);
			return itemDetailsDTO;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Set<ItemDetailsDTO> getItemDetailsAll(){
		Set<ItemDetailsDTO> set = new HashSet<ItemDetailsDTO>();
		try {	
			Connection con = DBUtility.getConnection(prop);
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("Select * from item_details");
			
			while(rs.next()) {
				ItemDetailsDTO itemDetailsDTO = ItemDetailsDTO.getItemDetailsDTO();
				itemDetailsDTO.setItemNo(rs.getInt("item_no"));
				itemDetailsDTO.setCategoryID(rs.getInt("category_id"));
				itemDetailsDTO.setItemDesc(rs.getString("item_desc"));
				itemDetailsDTO.setItemPrice(rs.getDouble("item_price"));
				itemDetailsDTO.setItemUnit(rs.getString("item_unit"));
				itemDetailsDTO.setCategoryName(rs.getString("category_name"));
				set.add(itemDetailsDTO);
			}
			DBUtility.closeConnection(null);
			return set;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Set<ItemDetailsDTO> getItemDetailsByCategory(int categoryID){
		Set<ItemDetailsDTO> set = new HashSet<ItemDetailsDTO>();
		try {	
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("Select * from item_details where category_id=?");
			st.setInt(1, categoryID);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				ItemDetailsDTO itemDetailsDTO = ItemDetailsDTO.getItemDetailsDTO();
				itemDetailsDTO.setItemNo(rs.getInt("item_no"));
				itemDetailsDTO.setCategoryID(categoryID);
				itemDetailsDTO.setItemDesc(rs.getString("item_desc"));
				itemDetailsDTO.setItemPrice(rs.getDouble("item_price"));
				itemDetailsDTO.setItemUnit(rs.getString("item_unit"));
				itemDetailsDTO.setCategoryName(rs.getString("category_name"));
				set.add(itemDetailsDTO);
			}
			DBUtility.closeConnection(null);
			return set;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int deleteItemDetails(ItemDetailsDTO itemDetailsDTO){
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("delete from item_details where item_no=?");
			st.setInt(1, itemDetailsDTO.getItemNo());
			
			int count = st.executeUpdate();
			con.commit();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception ee) {
			ee.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int updateItemDetails(ItemDetailsDTO itemDetailsDTO){
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("update item_details set category_id=?,item_desc=?,item_price=?,item_unit=?,category_name=? where item_no=?");
			st.setInt(1, itemDetailsDTO.getCategoryID());
			st.setString(2, itemDetailsDTO.getItemDesc());
			st.setDouble(3, itemDetailsDTO.getItemPrice());
			st.setString(4, itemDetailsDTO.getItemUnit());
			st.setString(5, itemDetailsDTO.getCategoryName());
			st.setInt(6, itemDetailsDTO.getItemNo());
			
			int count = st.executeUpdate();
			con.commit();
			DBUtility.closeConnection(null);
			return count;
		}catch(Exception ee) {
			ee.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("D:\\java\\workspace\\webAssignment\\WebContent\\WEB-INF\\dbconfig.properties"));
			Class.forName(prop.getProperty("driver"));
			ItemDetailsDAOImpl itemDetailsDAOImpl = ItemDetailsDAOImpl.getItemDetailsDAOImpl(prop);
//			ItemDetailsDTO itemDetailsDTO = ItemDetailsDTO.getItemDetailsDTO();
//			itemDetailsDTO.setItemNo(9);
//			itemDetailsDTO.setCategoryID(3);
//			itemDetailsDTO.setItemDesc("Banana");
//			itemDetailsDTO.setItemPrice(60.0);
//			itemDetailsDTO.setItemUnit("kg");
//			itemDetailsDTO.setCategoryName("Fuit");
//			itemDetailsDAOImpl.insertItemDetails(itemDetailsDTO);
			

			System.out.println(itemDetailsDAOImpl.getItemDetails(1));
			Set<ItemDetailsDTO> set = itemDetailsDAOImpl.getItemDetailsByCategory(3);
			System.out.println(set);
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
