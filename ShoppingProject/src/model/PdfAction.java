package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.XMLToPdfConveter;
import service.InvoiceService;
import service.InvoiceServiceImpl;

public class PdfAction extends Action{
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
			XMLToPdfConveter converter = new XMLToPdfConveter();
			converter.convert(xmlFile);
			return "Invoice.Success";
		}catch(Exception e) {e.printStackTrace();return null;}
	}
}
