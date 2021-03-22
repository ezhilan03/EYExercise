package EYExercise.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import EYExercise.assignment.consignmentTrack.BreakInterval;
import EYExercise.assignment.consignmentTrack.ConsignmentTrack;
import EYExercise.assignment.excelGenerator.XMLToExcelConverter;
import EYExercise.assignment.pdfGenerator.XMLToPdfConveter;
import EYExercise.day22.invoicejdbc.CustomerDetailsDAOImpl;
import EYExercise.day22.invoicejdbc.CustomerDetailsDTO;
import EYExercise.day22.invoicejdbc.InvoiceMasterDAOImpl;
import EYExercise.day22.invoicejdbc.InvoiceMasterDTO;
import EYExercise.day22.invoicejdbc.ItemDetailsDAOImpl;
import EYExercise.day22.invoicejdbc.ItemDetailsDTO;
import EYExercise.day22.invoicejdbc.ItemTransactionDAOImpl;
import EYExercise.day22.invoicejdbc.ItemTransactionDTO;


public class InvoiceServer extends UnicastRemoteObject implements Invoice{
	
	CustomerDetailsDAOImpl customerImpl = new CustomerDetailsDAOImpl();
	InvoiceMasterDAOImpl invImpl = new InvoiceMasterDAOImpl();
	ItemTransactionDAOImpl transacImpl = new ItemTransactionDAOImpl();
	ItemDetailsDAOImpl itemImpl = new ItemDetailsDAOImpl();
	
	public InvoiceServer() throws RemoteException{
		
	}
	
	@Override
	public void createInvoice(InvoiceMasterDTO inv1, CustomerDetailsDTO customer1, ItemTransactionDTO transac1) throws Exception{
			
		invImpl.insertInvoice(inv1);
		
		customerImpl.insertCustomerDetails(customer1);
		
		transacImpl.insertItemTransaction(transac1);
		
		System.out.println("Invoice created successfully");
	}
	
	public LocalDateTime calculateDate(int distance,int speed,int ihours,int iminutes,int iseconds) throws Exception {

		ConsignmentTrack tracker = new ConsignmentTrack(LocalDateTime.now(), distance, speed, new BreakInterval(ihours,iminutes,iseconds));
	    return tracker.getDeliveryDateAndTime();
	    
	}
	@Override
	public void createExcel(int invNo)throws Exception{
		String xmlFile = getXML(invNo);
		XMLToExcelConverter excelConverter = new XMLToExcelConverter();
		excelConverter.writeData(xmlFile);
	}
	
	@Override
	public void createPdf(int invNo) throws Exception {
		String xmlFile = getXML(invNo);
		XMLToPdfConveter pdfConverter = new XMLToPdfConveter();
		pdfConverter.convert(xmlFile);
		
	}
	
	@Override
	public void createItem(ItemDetailsDTO item1) throws Exception {
		itemImpl.insertItemDetails(item1);
		System.out.println("Item created successfully");
	}
	
	@Override
	public int getLengthOfTable() throws Exception{
		int length = invImpl.getLength();
		return length;
	}
	
	public String getXML(int invNo) {
		FileWriter fileWriter;
		
		StringBuilder xml = new StringBuilder();
		InvoiceMasterDTO inv1 = invImpl.getInvoiceMaster(invNo);
		int customerNo = inv1.getCustomerno();
		
		CustomerDetailsDTO customer1 = customerImpl.getCustomerDetailsDTO(customerNo);
		
		Set<ItemTransactionDTO> set = new HashSet<>();
		set = transacImpl.getItemTransactionForParticularInvoice(invNo);
		
		xml.append("<!DOCTYPE invoice SYSTEM \"D:\\java\\workspace\\eycorebasic\\invoice.dtd\">");
		xml.append("<invoice>");
		xml.append("<customername>");
		xml.append(customer1.getCustomerName());
		xml.append("</customername>");
		xml.append("<invno>");
		xml.append(invNo);
		xml.append("</invno>");
		xml.append("<invdate>");
		xml.append(inv1.getInvdate());
		xml.append("</invdate>");
		xml.append("<items>");
		Iterator<ItemTransactionDTO> iter = set.iterator();
		while(iter.hasNext()) {
			ItemTransactionDTO transac1 = iter.next();
			int itemNo = transac1.getItemNo();
			ItemDetailsDTO item1 = itemImpl.getItemDetails(itemNo);
			xml.append("<item>");
			xml.append("<itemno>");
			xml.append(item1.getItemNo());
			xml.append("</itemno>");
			xml.append("<itemname>");
			xml.append(item1.getItemDesc());
			xml.append("</itemname>");
			xml.append("<itemprice>");
			xml.append(item1.getItemPrice());
			xml.append("</itemprice>");
			xml.append("<itemquantity>");
			xml.append(transac1.getItemQuantity());
			xml.append("</itemquantity>");
			xml.append("<itemamount>");
			xml.append(item1.getItemPrice() * transac1.getItemQuantity());
			xml.append("</itemamount>");
			xml.append("</item>");
		}
		xml.append("</items>");
		xml.append("<gst></gst>");
		xml.append("<net></net>");
		xml.append("</invoice>");
		
		try {
			File output = new File("D:\\java\\workspace\\eycorebasic\\src\\EYExercise\\assignment\\invoice.xml");
			if(output.createNewFile()) {
				fileWriter = new FileWriter(output);
			}
			else {
				fileWriter = new FileWriter(output,false);
			}
			
			fileWriter.write(xml.toString());
			fileWriter.flush();
			fileWriter.close();
			
			return output.getAbsolutePath();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}