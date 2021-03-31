package model;

import java.util.Properties;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginService;
import service.LoginServiceImpl;


@WebListener
public class MySessionListener implements HttpSessionListener {



    public void sessionCreated(HttpSessionEvent se)  { 
       
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         String uname = (String)session.getAttribute("uname");
         
         Properties prop = (Properties)session.getServletContext().getAttribute("prop");
		 LoginService loginService = (LoginService)LoginServiceImpl.getLoginServiceImpl(prop);
		
		 loginService.updateFlag(uname, 0);
         System.out.println("session deleted");
    }
	
}
