package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class LogoutAction extends Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String uname =(String)session.getAttribute("uname");
			Properties prop = (Properties)request.getServletContext().getAttribute("prop");
			LoginService loginService = (LoginService)LoginServiceImpl.getLoginServiceImpl(prop);
			
			loginService.updateFlag(uname, 0);
			return "Logout.Success";
		}catch(Exception e) {e.printStackTrace();return null;}
	}
}
