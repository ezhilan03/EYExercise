package model.jdbc;

import java.util.Set;

public interface CustomerDetailsDAO {
	public int insertCustomerDetails(CustomerDetailsDTO customerDetailsDTO);
	public int deleteCustomerDetails(int customerNo);
	public int updateCustomerDetails(CustomerDetailsDTO customerDetailsDTO,String customerName);
	public CustomerDetailsDTO getCustomerDetailsDTO(int customerNo);
	public Set<CustomerDetailsDTO> getCustomerDetailsAll();
}
