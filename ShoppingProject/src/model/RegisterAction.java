package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.ResultStreamer;

import service.LoginService;
import service.LoginServiceImpl;

public class RegisterAction extends Action{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String uname = request.getParameter("uname");
			String upass = request.getParameter("upass");
			Properties prop = (Properties)request.getServletContext().getAttribute("prop");
			LoginService loginService = (LoginService)LoginServiceImpl.getLoginServiceImpl(prop);
			
			loginService.registerUser(uname,upass);
			return "Register.Success";
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	
}