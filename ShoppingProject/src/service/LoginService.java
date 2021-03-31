package service;

import model.jdbc.UserDTO;

public interface LoginService {
	public boolean checkUser(String uname,String upass);
	public boolean checkFlag(String uname);
	public int updateFlag(String uname,int flag);
	public int registerUser(String uname, String upass);
	public int getID();
	public int getCustomerNo(String uname);
}
