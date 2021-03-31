package model;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import model.jdbc.ItemDetailsDAOImpl;
import model.jdbc.ItemDetailsDTO;
import service.ShoppingService;
import service.ShoppingServiceImpl;

public class Product extends TagSupport{
	private String category;

	public final String getCategory() {
		return category;
	}

	public final void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public int doEndTag() throws JspException {
		int c = Integer.parseInt(category);
		JspWriter out=pageContext.getOut();
		
		HttpSession session = pageContext.getSession();
		Properties prop = (Properties)session.getServletContext().getAttribute("prop");
		ShoppingService shoppingService = (ShoppingService)ShoppingServiceImpl.getShoppingServiceImpl(prop);
		
		Set<ItemDetailsDTO> itemDetailsSet = shoppingService.getItems(c);
		try {
			
			Iterator<ItemDetailsDTO> iter = itemDetailsSet.iterator();
		     while(iter.hasNext()){
		    	 
		    	 ItemDetailsDTO item = iter.next();
		    	 
		    	 out.println(item.getItemDesc()
		    	 +":<input type=\"checkbox\" name=\""+item.getItemNo()
		    	 +"\" value=\""+item.getItemDesc()+"\">"+"&nbsp Quantity: "
		    	 +"<input type=\"number\" name=\"quantity\" <br>");
		     }
			
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.doEndTag();
	}
}
