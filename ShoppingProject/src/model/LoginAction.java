package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginAction extends Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			Properties prop = (Properties)request.getServletContext().getAttribute("prop");
			
			HttpSession session = request.getSession();
			LoginService loginService = (LoginService)LoginServiceImpl.getLoginServiceImpl(prop);
			
			if(loginService.checkUser(uname, upass)) {
				if(loginService.checkFlag(uname)) {
					int customerNo = loginService.getCustomerNo(uname);
					
					session.setAttribute("customerNo", customerNo);
					session.setAttribute("uname", uname);
					session.setAttribute("upass", upass);
					loginService.updateFlag(uname, 1);
					
					return "Login.Success";
				}
				else {
					return "Login.Repeat";
				}
			}
			else {
				return "Login.Failure";
			}
			
		}catch(Exception ee) {ee.printStackTrace();return null;}
	}
}
