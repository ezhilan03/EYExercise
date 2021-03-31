package service;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import model.jdbc.CustomerDetailsDAOImpl;
import model.jdbc.CustomerDetailsDTO;
import model.jdbc.InvoiceMasterDAO;
import model.jdbc.InvoiceMasterDAOImpl;
import model.jdbc.InvoiceMasterDTO;
import model.jdbc.ItemDetailsDAOImpl;
import model.jdbc.ItemDetailsDTO;
import model.jdbc.ItemTransactionDAO;
import model.jdbc.ItemTransactionDAOImpl;
import model.jdbc.ItemTransactionDTO;


public class InvoiceServiceImpl implements InvoiceService,Cloneable{
	private static Properties prop;
	private static InvoiceServiceImpl invoiceServiceImpl;
	
	private InvoiceServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	public static InvoiceServiceImpl getInvoiceServiceImpl(Properties prop) {
		if(invoiceServiceImpl==null) {
			invoiceServiceImpl=new InvoiceServiceImpl(prop);
		}
		return invoiceServiceImpl;
	}
	
	public InvoiceServiceImpl createClone() {
		try {
			return (InvoiceServiceImpl)super.clone();
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
	public String getXML(int invNo,Double total) {
		XMLServiceImpl xmlServiceImpl = XMLServiceImpl.getXMLServiceImpl(prop);
		return xmlServiceImpl.createXML(invNo, total);
	}
	
	public int createInvoice(int invNo,int customerNo,List<Integer> itemList) {
		
		InvoiceMasterDAO invoiceMasterDAOImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		InvoiceMasterDTO invoiceMasterDTO = InvoiceMasterDTO.getInvoiceMasterDTO();
		
		
		java.sql.Date date = new java.sql.Date(2021-04-29);
		
		invoiceMasterDTO.setInvno(invNo);
		invoiceMasterDTO.setInvdate(date);
		invoiceMasterDTO.setCustomerno(customerNo);
		int result = invoiceMasterDAOImpl.insertInvoice(invoiceMasterDTO);
		
		ItemTransactionDAO itemTransactionDAOImpl = ItemTransactionDAOImpl.getItemTransactionDAOImpl(prop);
		
		
		for(int itemNo:itemList) {
			ItemTransactionDTO itemTransactionDTO = ItemTransactionDTO.getItemTransactionDTO();
			itemTransactionDTO.setItemQuantity(1);
			itemTransactionDTO.setInvNo(invNo);
			itemTransactionDTO.setItemNo(itemNo);
			
			itemTransactionDAOImpl.insertItemTransaction(itemTransactionDTO);
		}
		return result;
	}
	
	@Override
	public int getInvNo() {
		InvoiceMasterDAO invoiceMasterDAOImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		int invNo = invoiceMasterDAOImpl.getLength()+1;
		return invNo;
	}
}
