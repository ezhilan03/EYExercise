package service;

import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import model.jdbc.CustomerDetailsDAOImpl;
import model.jdbc.CustomerDetailsDTO;
import model.jdbc.InvoiceMasterDAOImpl;
import model.jdbc.InvoiceMasterDTO;
import model.jdbc.ItemDetailsDAOImpl;
import model.jdbc.ItemDetailsDTO;
import model.jdbc.ItemTransactionDAOImpl;
import model.jdbc.ItemTransactionDTO;

public class XMLServiceImpl implements XMLService,Cloneable{
	private static Properties prop;
	private static XMLServiceImpl xmlServiceImpl;
	
	private XMLServiceImpl(Properties prop) {
		this.prop=prop;
	}
	
	public static XMLServiceImpl getXMLServiceImpl(Properties prop) {
		if(xmlServiceImpl==null) {
			xmlServiceImpl=new XMLServiceImpl(prop);
		}
		return xmlServiceImpl;
	}
	
	public XMLServiceImpl createClone() {
		try {
			return (XMLServiceImpl)super.clone();
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	@Override
	public String createXML(int invNo, Double total) {
		CustomerDetailsDAOImpl customerImpl = CustomerDetailsDAOImpl.getCustomerDetailsDAOImpl(prop);
		InvoiceMasterDAOImpl invImpl = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		ItemTransactionDAOImpl transacImpl =ItemTransactionDAOImpl.getItemTransactionDAOImpl(prop);
		ItemDetailsDAOImpl itemImpl = ItemDetailsDAOImpl.getItemDetailsDAOImpl(prop);
		
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
		xml.append("<net>");
		xml.append(total);
		xml.append("</net>");
		xml.append("</invoice>");
		
		try {
			File output = new File("C:\\Users\\ezhil\\OneDrive\\Desktop\\invoice.xml");
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
