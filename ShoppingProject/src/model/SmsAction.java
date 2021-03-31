package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.SmsService;
import components.SmsServiceImpl;
import components.XMLToPdfConveter;
import service.InvoiceService;
import service.InvoiceServiceImpl;

public class SmsAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Properties prop = (Properties)request.getServletContext().getAttribute("prop");
			
			int invNo = (int)session.getAttribute("invNo");
			Double total = (Double)session.getAttribute("total");
			InvoiceService invoiceService = InvoiceServiceImpl.getInvoiceServiceImpl(prop);
			String xmlFile = invoiceService.getXML(invNo,total);
			System.out.println(xmlFile);
			SmsService smsService = SmsServiceImpl.getSmsServiceImpl(prop);
			smsService.sendSMS(xmlFile);
			return "Invoice.Success";
		}catch(Exception e) {e.printStackTrace();return null;}
	}
}
