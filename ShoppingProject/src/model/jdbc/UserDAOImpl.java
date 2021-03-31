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

public class UserDAOImpl implements UserDAO,Cloneable{
	private Properties prop;
	private static UserDAOImpl userDAOImpl;
	
	private UserDAOImpl(Properties prop) {
		this.prop=prop;
	}
	
	synchronized public static UserDAOImpl getUserDAOImpl(Properties prop) {
		if(userDAOImpl==null) {
			userDAOImpl = new UserDAOImpl(prop);
			return userDAOImpl;
		}
		else {
			return userDAOImpl.createClone();
		}
	}
	
	public UserDAOImpl createClone() {
		try {
			return (UserDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int insertUser(UserDTO userDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("insert into login_details values(?,?,?,?)");
			st.setInt(1, userDTO.getUid());
			st.setString(2, userDTO.getUname());
			st.setString(3, userDTO.getUpass());
			st.setInt(4, userDTO.getFlag());
			
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
	public UserDTO getUserDTO(int uid) {
		try {
			UserDTO userDTO = UserDTO.getUserDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("Select * from login_details where s_no=?");
			st.setInt(1, uid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				userDTO.setUid(rs.getInt("s_no"));
				userDTO.setUname(rs.getString("user_name"));
				userDTO.setUpass(rs.getString("password"));
				userDTO.setFlag(rs.getInt("flag"));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<UserDTO> getAllUserDTO() {
		Set<UserDTO> set = new HashSet<UserDTO>();
		try {	
			Connection con = DBUtility.getConnection(prop);
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("Select * from login_details");
			
			while(rs.next()) {
				UserDTO userDTO = UserDTO.getUserDTO();
				userDTO.setUid(rs.getInt("s_no"));
				userDTO.setUname(rs.getString("user_name"));
				userDTO.setUpass(rs.getString("password"));
				userDTO.setFlag(rs.getInt("flag"));
				set.add(userDTO);
			}
			DBUtility.closeConnection(null);
			return set;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}

	@Override
	public int deleteUser(UserDTO userDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("delete from login_details where s_no=? and user_name=?");
			st.setInt(1, userDTO.getUid());
			st.setString(2, userDTO.getUname());
			
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
	public int updateUser(UserDTO userDTO) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("update login_details set user_name=?, password=?, flag=? where s_no=?");
			st.setString(1, userDTO.getUname());
			st.setString(2, userDTO.getUpass());
			st.setInt(3, userDTO.getFlag());
			st.setInt(4, userDTO.getUid());
			
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
	public UserDTO getUserDTObyName(String uname) {
		try {
			UserDTO userDTO = UserDTO.getUserDTO();
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("Select * from login_details where user_name=?");
			st.setString(1, uname);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				userDTO.setUid(rs.getInt("s_no"));
				userDTO.setUname(rs.getString("user_name"));
				userDTO.setUpass(rs.getString("password"));
				userDTO.setFlag(rs.getInt("flag"));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		}catch(Exception ee) {
			ee.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int setFlag(UserDTO userDTO,int flag) {
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement st = con.prepareStatement("update login_details set flag=? where user_name=? and password=?");
			st.setInt(1, flag);
			st.setString(2, userDTO.getUname());
			st.setString(3, userDTO.getUpass());

			
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
	public int getLength() {
		try {
			Connection con = DBUtility.getConnection(prop);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from login_details");
			rs.next();
			int count = rs.getInt("count(*)");
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
			UserDAOImpl userDAOImpl = UserDAOImpl.getUserDAOImpl(prop);
//			UserDTO userDTO = new UserDTO();
//			userDTO.setUid(1);
//			userDTO.setUname("ezhilan");
//			userDTO.setUpass("1234");
//			userDTO.setFlag(0);
////			int i = userDAOImpl.deleteUser(userDTO);
//			userDAOImpl.setFlag(userDTO, 0);
			System.out.println(userDAOImpl.getLength());
			Set<UserDTO> set = userDAOImpl.getAllUserDTO();
			System.out.println(set);
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
