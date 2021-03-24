package day25;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Example3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        // Get enumeration of parameter names
        Enumeration e = request.getParameterNames();
        //display parameter names and values
        while(e.hasMoreElements()){
           String pname = (String) e.nextElement();
           String pvalue = request.getParameter(pname);
           pw.println(pname+" : "+pvalue);
        }           pw.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
