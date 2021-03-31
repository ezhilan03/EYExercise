package model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import model.DBUtility;


public class ItemTransactionDAOImpl implements ItemTransactionDAO,Cloneable{
	private Properties prop;
	private static ItemTransactionDAOImpl itemTransactionDAOImpl;
	
	private ItemTransactionDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static ItemTransactionDAOImpl getItemTransactionDAOImpl(Properties prop) {
		if(itemTransactionDAOImpl==null) {
			itemTransactionDAOImpl = new ItemTransactionDAOImpl(prop);
			return itemTransactionDAOImpl;
		}
		else {
			return itemTransactionDAOImpl.createClone();
		}
	}
	
	public ItemTransactionDAOImpl createClone() {
		try {
			return (ItemTransactionDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertItemTransaction(ItemTransactionDTO itemTransactionDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "insert into item_transaction(item_no,inv_no,item_quantity) values(?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, itemTransactionDTO.getItemNo());
			st.setInt(2, itemTransactionDTO.getInvNo());
			st.setInt(3, itemTransactionDTO.getItemQuantity());
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
	public int deleteItemTransaction(int invNo,int itemNo) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "delete from item_transaction where inv_no = ? and item_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invNo);
			st.setInt(2, itemNo);
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
	public int updateItemTransaction(ItemTransactionDTO itemTransactionDTO,int itemQuantity) {
		try {
			Connection con = DBUtility.getConnection(prop);
			int itemNo = itemTransactionDTO.getItemNo();
			int invNo = itemTransactionDTO.getInvNo();
			String query = "update item_transaction set item_quantity = ? where item_no = ? and inv_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, itemQuantity);
			st.setInt(2, itemNo);
			st.setInt(3, invNo);
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
	public ItemTransactionDTO getItemTransaction(int invNo, int itemNo) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "select * from item_transaction where inv_no = ? and item_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invNo);
			st.setInt(2, itemNo);
			ResultSet rs = st.executeQuery();
			ItemTransactionDTO itemTransac = null;
			if(rs.next()) {
//				int itemNo = rs.getInt("item_no");
//				int invNo = rs.getInt("inv_no");
				int itemQuantity = rs.getInt("item_quantity");
				
				itemTransac = ItemTransactionDTO.getItemTransactionDTO();
				itemTransac.setInvNo(invNo);
				itemTransac.setItemNo(itemNo);
				itemTransac.setItemQuantity(itemQuantity);
				
				return itemTransac;
			}
			return itemTransac;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Set<ItemTransactionDTO> getItemTransactionAll() {
		Set<ItemTransactionDTO> set = new HashSet<ItemTransactionDTO>();
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "select * from item_transaction";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int itemNo = rs.getInt("item_no");
				int invNo = rs.getInt("inv_no");
				int itemQuantity = rs.getInt("item_quantity");
				
				ItemTransactionDTO itemTransac = ItemTransactionDTO.getItemTransactionDTO();
				itemTransac.setInvNo(invNo);
				itemTransac.setItemNo(itemNo);
				itemTransac.setItemQuantity(itemQuantity);
				
				set.add(itemTransac);
			}
			return set;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Set<ItemTransactionDTO> getItemTransactionForParticularInvoice(int invNo) {
		Set<ItemTransactionDTO> set = new HashSet<ItemTransactionDTO>();
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "select * from item_transaction where inv_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invNo);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int itemNo = rs.getInt("item_no");
				int itemQuantity = rs.getInt("item_quantity");
				
				ItemTransactionDTO itemTransac = ItemTransactionDTO.getItemTransactionDTO();
				itemTransac.setInvNo(invNo);
				itemTransac.setItemNo(itemNo);
				itemTransac.setItemQuantity(itemQuantity);
				
				set.add(itemTransac);
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
