package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Integer> itemList= new ArrayList<Integer>();
		HttpSession session = request.getSession();
		session.setAttribute("list", itemList);
		return "Shop.Success";
	}
	
}
