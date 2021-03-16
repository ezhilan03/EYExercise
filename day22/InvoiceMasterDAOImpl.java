package EYExercise.day22;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import EYExercise.day21.DBUtility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	Connection con;
	
	public InvoiceMasterDAOImpl() {
		con = DBUtility.getConnection();
	}
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invMasterDTO) {
		try {
		
			String query = "insert into invoice_master(inv_no,inv_date,customer_no) values(?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invMasterDTO.getInvno());
			st.setDate(2, invMasterDTO.getInvdate());
			st.setInt(3, invMasterDTO.getCustomerno());
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
	public int deleteInvoice(int invno) {
		try {
			String query = "delete from invoice_master where inv_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invno);
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
	public int updateInvoice(InvoiceMasterDTO invMasterDTO,int customerNo) {
		try {
			int invNo = invMasterDTO.getInvno();
			String query = "update invoice_master set customer_no = ? where inv_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, customerNo);
			st.setInt(2, invNo);
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
	public InvoiceMasterDTO getInvoiceMaster(int invno) {
		try {
			String query = "select * from invoice_master where inv_no = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, invno);
			ResultSet rs = st.executeQuery();
			InvoiceMasterDTO invMaster = null;
			if(rs.next()) {
				Date invDate = rs.getDate("inv_date");
				int customerNo = rs.getInt("customer_no");
				invMaster = new InvoiceMasterDTO();
				invMaster.setCustomerno(customerNo);
				invMaster.setInvdate(invDate);
				invMaster.setInvno(invno);
				return invMaster;
			}
			return invMaster;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		Set<InvoiceMasterDTO> set = new HashSet<InvoiceMasterDTO>();
		try {
			Statement st = con.createStatement();
			String query = "select * from invoice_master";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int invNo = rs.getInt("inv_no");
				Date invDate = rs.getDate("inv_date");
				int customerNo = rs.getInt("customer_no");
				InvoiceMasterDTO invMaster = new InvoiceMasterDTO();
				invMaster.setCustomerno(customerNo);
				invMaster.setInvdate(invDate);
				invMaster.setInvno(invNo);
				set.add(invMaster);
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