package service;

import java.util.List;

public interface InvoiceService {
	public int createInvoice(int invNo,int customerNo,List<Integer> itemList);
	public String getXML(int invNo,Double total);
	public int getInvNo();
}
