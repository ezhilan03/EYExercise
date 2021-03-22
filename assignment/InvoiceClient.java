package EYExercise.assignment;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.sql.Date;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;

import EYExercise.day22.invoicejdbc.CustomerDetailsDTO;
import EYExercise.day22.invoicejdbc.InvoiceMasterDAOImpl;
import EYExercise.day22.invoicejdbc.InvoiceMasterDTO;
import EYExercise.day22.invoicejdbc.ItemDetailsDTO;
import EYExercise.day22.invoicejdbc.ItemTransactionDTO;


public class InvoiceClient {
	
	public static void main(String[] args) throws Exception{
		Invoice inv=(Invoice)Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		InputStreamReader inputStream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStream); 
		Console console = System.console();
		
		System.out.println("Please enter your choice...");
		System.out.println("1-Create new Invoice");
		System.out.println("2-Calculate Delivery date and time of delivery");
		System.out.println("3-To generate PDF of Invoice");
		System.out.println("4-To generate Excel of Invoice");
		System.out.println("5-Enter new item");
		
		int choice=reader.read();
		reader.readLine();
		switch(choice) {
		case '1':{
			int invNo =inv.getLengthOfTable()+1;
			int customerNo = invNo;
			
			Date invDate = new Date(2021-03-17);
			System.out.println("Enter customer name");
			String customerName = reader.readLine();
			String customerEmail = customerName + "@gmail.com";
			String customerAddress = customerName + "address";
			System.out.println("enter customer phone number");
			long customerPhone = Long.parseLong(reader.readLine());
			
			System.out.println("enter item no");
			int itemNo =  Integer.parseInt(reader.readLine());
			System.out.println("enter quantity");
			int itemQuantity =  Integer.parseInt(reader.readLine());
			
			InvoiceMasterDTO inv1 = new InvoiceMasterDTO();
			inv1.setCustomerno(customerNo);
			inv1.setInvno(invNo);
			inv1.setInvdate(invDate);
			

			CustomerDetailsDTO customer1 = new CustomerDetailsDTO();
			customer1.setCustomerNo(customerNo);
			customer1.setCustomerName(customerName);
			customer1.setCustomerEmail(customerEmail);
			customer1.setCustomerPhone(customerPhone);
			customer1.setCustomerAddress(customerAddress);
			
			ItemTransactionDTO transac1 = new ItemTransactionDTO();
			transac1.setInvNo(invNo);
			transac1.setItemNo(itemNo);
			transac1.setItemQuantity(itemQuantity);
			
			inv.createInvoice(inv1,customer1,transac1);
			reader.close();
			inputStream.close();
			break;
		}
		case '2':{
			System.out.println("Enter the distance in km");
		    int distance = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the speed in km/hr");
		    int speed = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval hours");
		    int ihours = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval minutes");
		    int iminutes = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Enter the interval seconds");
		    int iseconds = Integer.parseInt(reader.readLine());
		    
		    System.out.println("Estimated Arrival Time : "+ inv.calculateDate(distance,speed,ihours,iminutes,iseconds));
		    break;
		}
		case '3':{
			System.out.println("Enter the invoice number");
			int invNo = Integer.parseInt(reader.readLine());
			inv.createPdf(invNo);
			break;
		}
		case '4':{
			System.out.println("Enter the invoice number");
			int invNo = Integer.parseInt(reader.readLine());
			inv.createExcel(invNo);
			break;
		}
		case '5':{
			System.out.println("Enter item number");
			int itemNo = Integer.parseInt(reader.readLine());
			System.out.println("Enter item description");
			String itemDesc = reader.readLine();
			System.out.println("Enter item price");
			double itemPrice = Double.parseDouble(reader.readLine());
			System.out.println("Enter item unit");
			String itemUnit = reader.readLine();
			
			ItemDetailsDTO item1 = new ItemDetailsDTO();
			item1.setItemNo(itemNo);
			item1.setItemDesc(itemDesc);
			item1.setItemPrice(itemPrice);
			item1.setItemUnit(itemUnit);
			inv.createItem(item1);
			break;
		}
		default:
			System.out.println("wrong choice...");
		}
		
	}
}