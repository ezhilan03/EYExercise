package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.XMLToExcelConverter;
import service.InvoiceService;
import service.InvoiceServiceImpl;

public class ExcelAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Properties prop = (Properties)request.getServletContext().getAttribute("prop");
			
			int invNo = (int)session.getAttribute("invNo");
			InvoiceService invoiceService = InvoiceServiceImpl.getInvoiceServiceImpl(prop);
			Double total = (Double)session.getAttribute("total");
			String xmlFile = invoiceService.getXML(invNo,total);
			System.out.println(xmlFile);
			XMLToExcelConverter excelConverter = new XMLToExcelConverter();
			excelConverter.writeData(xmlFile);
			return "Invoice.Success";
		}catch(Exception e) {e.printStackTrace();return null;}
	}
}
