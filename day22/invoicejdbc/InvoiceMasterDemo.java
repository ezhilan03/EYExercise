package EYExercise.day22.invoicejdbc;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class InvoiceMasterDemo {
	public static void main(String[] args) {
		InvoiceMasterDAOImpl invImpl = new InvoiceMasterDAOImpl();
		
		InvoiceMasterDTO inv1 = new InvoiceMasterDTO();
		inv1.setCustomerno(1);
		inv1.setInvdate(new Date(2021-04-16));
		inv1.setInvno(1);
		
//		//insert :
//		System.out.println(invImpl.insertInvoice(inv1));
		
//		//delete
//		System.out.println(invImpl.deleteInvoice(1));
		
//		//update
//		System.out.println(invImpl.updateInvoice(inv1, 5));
		
		//get
		inv1 = invImpl.getInvoiceMaster(1);
		System.out.println(inv1);
		
		//get all
		Set<InvoiceMasterDTO> set = new HashSet<>();
		set = invImpl.getInvoiceMasterAll();
		System.out.println(set);
		
		invImpl.closeConnection();
	}
}
