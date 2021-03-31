package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import service.InvoiceService;
import service.InvoiceServiceImpl;
import service.ShoppingService;
import service.ShoppingServiceImpl;

public class ProductList extends TagSupport{
	@Override
	public int doEndTag() throws JspException {
		int count=0;
		JspWriter out=pageContext.getOut();	
		
		HttpSession session = pageContext.getSession();
		Properties prop = (Properties)session.getServletContext().getAttribute("prop");
		ShoppingService shoppingService = (ShoppingService)ShoppingServiceImpl.getShoppingServiceImpl(prop);
		List<Integer> itemList=(ArrayList<Integer>)session.getAttribute("list");
		
		int customerNo = (int)session.getAttribute("customerNo");
		InvoiceService invoiceService = (InvoiceService)InvoiceServiceImpl.getInvoiceServiceImpl(prop);
		int invNo = invoiceService.getInvNo();
		Double total = shoppingService.getTotal(itemList);
		session.setAttribute("total", total);
		System.out.println("Invoice number is "+invNo);
		session.setAttribute("invNo", invNo);
		invoiceService.createInvoice(invNo,customerNo,itemList);
		
		
		try {
			out.println("<table style=\"width:25%\"> ");
			out.println("<tr>");
			out.println("<th>S.No<th>");
			out.println("<th>"+"Item Name"+"</th>");
			out.println("<th>"+"Item price"+"</th>");
			out.println("</tr>");
			
			
			for(int itemNo:itemList) {
				out.println("<tr>");
				out.println("<td>"+(++count)+"<td>");
				out.println("<td>"+shoppingService.getItemName(itemNo)+"</td>");
				out.println("<td>"+shoppingService.getItemPrice(itemNo)+"</td>");
				out.println("</tr>");
			}
			out.println("<tr>");
			out.println("<td>"+"<td>");
			out.println("<td>"+"Total:"+"</td>");
			out.println("<td>"+total+"</td>");
			out.println("</tr>");
			out.println("</table>");
		}catch(Exception e) {e.printStackTrace();}
		
		return super.doEndTag();
	}
}
