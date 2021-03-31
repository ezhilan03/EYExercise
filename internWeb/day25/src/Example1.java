package InternExercise.internWeb.day25.src;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Example1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name =(String)request.getParameter("name");
	      out.println("<HTML>");
	      out.println("<HEAD><TITLE>Hello "+name+"</TITLE></HEAD>");
	      out.println("<BODY>");
	      out.println("<H1>Hello, <BLINK>"+name+"</BLINK></H1>");
	      out.println("</BODY>");
	      out.println("</HTML>");  
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
