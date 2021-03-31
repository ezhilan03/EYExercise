package service;

import java.util.Properties;

import model.DBUtility;
import model.jdbc.UserDAOImpl;
import model.jdbc.UserDTO;
import model.jdbc.CustomerDetailsDAO;
import model.jdbc.CustomerDetailsDAOImpl;
import model.jdbc.CustomerDetailsDTO;
import model.jdbc.UserDAO;

public class LoginServiceImpl implements LoginService,Cloneable{
	private static Properties prop;
	private static LoginServiceImpl loginServiceImpl;
	
	private LoginServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	public static LoginServiceImpl getLoginServiceImpl(Properties prop) {
		if(loginServiceImpl==null) {
			loginServiceImpl=new LoginServiceImpl(prop);
		}
		return loginServiceImpl;
	}
	
	public LoginServiceImpl createClone() {
		try {
			return (LoginServiceImpl)super.clone();
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserDTObyName(uname);
		if(userDTO.getUname()!=null && userDTO.getUpass()!=null) {
			if(userDTO.getUpass().equalsIgnoreCase(upass)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean checkFlag(String uname) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserDTObyName(uname);
		if(userDTO!=null) {
			if(userDTO.getFlag()==0 ){
				return true;	
			}
			return false;
		}
		return false;
	}

	@Override
	public int updateFlag(String uname, int flag) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserDTObyName(uname);
		if(userDTO!=null) {
			userDAO.setFlag(userDTO, flag);
			return 1;
		}
		return 0;
	}

	@Override
	public int registerUser(String uname, String upass) {
		int count = getID();
		
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = UserDTO.getUserDTO();
		userDTO.setUid(count);
		userDTO.setUname(uname);
		userDTO.setUpass(upass);
		userDTO.setFlag(0);
		int result = userDAO.insertUser(userDTO);
		
		CustomerDetailsDAO customerDetailsDAO = CustomerDetailsDAOImpl.getCustomerDetailsDAOImpl(prop);
		CustomerDetailsDTO customerDetailsDTO = CustomerDetailsDTO.getCustomerDetailsDTO();
		customerDetailsDTO.setCustomerName(uname);
		customerDetailsDTO.setCustomerEmail(uname+"@gmail.com");
		customerDetailsDTO.setCustomerAddress(uname+"\'s address");
		customerDetailsDTO.setCustomerNo(count);
		customerDetailsDTO.setCustomerPhone(1234567890);
		int result2 = customerDetailsDAO.insertCustomerDetails(customerDetailsDTO);
				
		return result;
	}
	
	@Override
	public int getID() {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		int id = userDAO.getLength()+1;
		return id;
	}
	
	@Override
	public int getCustomerNo(String uname) {
		UserDAO userDAO = UserDAOImpl.getUserDAOImpl(prop);
		UserDTO userDTO = userDAO.getUserDTObyName(uname);
		return userDTO.getUid();
	}
	
}
