package model.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import model.DBUtility;


public class CustomerDetailsDAOImpl implements CustomerDetailsDAO,Cloneable{
	private Properties prop;
	private static CustomerDetailsDAOImpl customerDetailsDAOImpl;
	
	private CustomerDetailsDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static CustomerDetailsDAOImpl getCustomerDetailsDAOImpl(Properties prop) {
		if(customerDetailsDAOImpl==null) {
			customerDetailsDAOImpl = new CustomerDetailsDAOImpl(prop);
			return customerDetailsDAOImpl;
		}
		else {
			return customerDetailsDAOImpl.createClone();
		}
	}
	
	public CustomerDetailsDAOImpl createClone() {
		try {
			return (CustomerDetailsDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertCustomerDetails(CustomerDetailsDTO customerDetailsDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "insert into customer_details(customer_no,customer_name,customer_email,customer_phone,customer_address) values(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, customerDetailsDTO.getCustomerNo());
			st.setString(2, customerDetailsDTO.getCustomerName());
			st.setString(3, customerDetailsDTO.getCustomerEmail());
			st.setLong(4, customerDetailsDTO.getCustomerPhone());
			st.setString(5,customerDetailsDTO.getCustomerAddress());
			
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
	public int deleteCustomerDetails(int customerNo) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "delete from customer_details where customer_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, customerNo);
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
	public int updateCustomerDetails(CustomerDetailsDTO customerDetailsDTO,String customerName){
		try {
			Connection con = DBUtility.getConnection(prop);
			int customerNo = customerDetailsDTO.getCustomerNo();
			String query = "update customer_details set customer_name = ? where customer_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, customerName);
			st.setInt(2, customerNo);
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
	public CustomerDetailsDTO getCustomerDetailsDTO(int customerNo) {
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "select * from customer_details where customer_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, customerNo);
			ResultSet rs = st.executeQuery();
			CustomerDetailsDTO customerDet = null;
			if(rs.next()) {
				String customerName = rs.getString("customer_name");
				String customerEmail = rs.getString("customer_email");
				long customerPhone = rs.getLong("customer_phone");
				String customerAddress = rs.getString("customer_address");
				
				customerDet = CustomerDetailsDTO.getCustomerDetailsDTO();
				customerDet.setCustomerNo(customerNo);
				customerDet.setCustomerName(customerName);
				customerDet.setCustomerEmail(customerEmail);
				customerDet.setCustomerPhone(customerPhone);
				customerDet.setCustomerAddress(customerAddress);
				
				return customerDet;
			}
			return customerDet;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public Set<CustomerDetailsDTO> getCustomerDetailsAll() {
		Set<CustomerDetailsDTO> set = new HashSet<CustomerDetailsDTO>();
		try {
			Connection con = DBUtility.getConnection(prop);
			String query = "select * from customer_details";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				String customerName = rs.getString("customer_name");
				String customerEmail = rs.getString("customer_email");
				long customerPhone = rs.getLong("customer_phone");
				String customerAddress = rs.getString("customer_address");
				int customerNo = rs.getInt("customer_no");
				
				CustomerDetailsDTO customerDet = CustomerDetailsDTO.getCustomerDetailsDTO();
				customerDet.setCustomerNo(customerNo);
				customerDet.setCustomerName(customerName);
				customerDet.setCustomerEmail(customerEmail);
				customerDet.setCustomerPhone(customerPhone);
				customerDet.setCustomerAddress(customerAddress);
				
				set.add(customerDet);
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
