package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ActionServlet", urlPatterns = {"*.action"}, initParams = 
{
	    @WebInitParam(name = "config", value = "/WEB-INF/config.properties"),
	    @WebInitParam(name = "dbconfig", value = "/WEB-INF/dbconfig.properties")
}

		)

public class ActionServlet extends HttpServlet {
	RequestProcessor rp;Properties prop;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String file = config.getInitParameter("config");
			String dbFile = config.getInitParameter("dbconfig");
			
			ServletContext sc = config.getServletContext();
			String filePath=sc.getRealPath(file);
			String dbFilePath = sc.getRealPath(dbFile);
			sc.setAttribute("path", filePath);
			
			
			prop = new Properties();
			prop.load(new FileInputStream(dbFilePath));
			Class.forName(prop.getProperty("driver"));
			sc.setAttribute("prop", prop);
			rp = RequestProcessor.getRequestProcessor();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.requestProcess(request, response);
		request.getSession().setMaxInactiveInterval(30);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

