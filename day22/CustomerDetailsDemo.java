package EYExercise.day22;

import java.util.HashSet;
import java.util.Set;

public class CustomerDetailsDemo {
	public static void main(String[] args) {
		CustomerDetailsDAOImpl customerimpl = new CustomerDetailsDAOImpl();
		
		CustomerDetailsDTO customer1 = new CustomerDetailsDTO();
		customer1.setCustomerNo(1);
		customer1.setCustomerName("Ezhilan");
		customer1.setCustomerEmail("ezhilan03@gmail.com");
		customer1.setCustomerAddress("18d asdasdasdasdasdasdasdasdasd");
		customer1.setCustomerPhone(8903589000L);
		
//		//insert:
//		System.out.println(customerimpl.insertCustomerDetails(customer1));
		
//		//delete 
//		System.out.println(customerimpl.deleteCustomerDetails(1));
		
//		//update
//		System.out.println(customerimpl.updateCustomerDetails(customer1, "joysan"));
		
		//get
		customer1 = customerimpl.getCustomerDetailsDTO(1);
		System.out.println(customer1);
		
		//get all
		Set<CustomerDetailsDTO> set = new HashSet<>();
		set = customerimpl.getCustomerDetailsAll();
		System.out.println(set);
		
		
	}
}
