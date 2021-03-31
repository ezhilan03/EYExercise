package control;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Action;

public class RequestProcessor {
	private static RequestProcessor rp;
	private RequestProcessor() {
		
	}
	
	public static RequestProcessor getRequestProcessor() {
		if(rp==null) {
			rp = new RequestProcessor();
		}
		return rp;
	}
	
	public void requestProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext application = request.getServletContext();
			String filePath = (String)application.getAttribute("path");
			
			HttpSession session = request.getSession();
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(filePath));
			String action = request.getParameter("action");
			String className = prop.getProperty(action);
			System.out.println(className);
			Action obj = (Action)Class.forName(className).getConstructor().newInstance();
			String result = obj.execute(request, response);
			System.out.println("action is"+result);
			String nextPage = prop.getProperty(result);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
