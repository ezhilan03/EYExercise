package model.jdbc;

import java.util.Set;

public interface UserDAO {
	public int insertUser(UserDTO userDTO);
	public UserDTO getUserDTO(int uid);
	public Set<UserDTO> getAllUserDTO();
	public int deleteUser(UserDTO userDTO);
	public int updateUser(UserDTO userDTO);
	public UserDTO getUserDTObyName(String uname);
	public int setFlag(UserDTO userDTO,int flag);
	public int getLength();
}
