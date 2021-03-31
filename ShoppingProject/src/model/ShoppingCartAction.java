package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String shopID = request.getParameter("shopid");
		HttpSession session = request.getSession();
		Enumeration<String> e = request.getParameterNames();
		
		List<Integer> itemList =(ArrayList<Integer>)session.getAttribute("list");
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			if(name.matches("[0-9]+")){
				itemList.add(Integer.parseInt(name));
			}
		
		}
		return shopID;
	}

}
