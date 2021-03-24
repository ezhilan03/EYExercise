package day25;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

public class Example4 extends HttpServlet {
	Connection con;
    PreparedStatement st;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
			st = con.prepareStatement("insert into emp values(?,?)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// first, set the "content type" header of the response
        String s1 = request.getParameter("name");
        String s2 = request.getParameter("age");
       response.setContentType("text/html");
       PrintWriter pw = response.getWriter();
       pw.println("<H1> Inserting Record:  </H1>");
       int x = Integer.parseInt(s2);
         try {
            st.setString(1,s1);
            st.setInt(2,x);
            st.executeUpdate();
           }catch(Exception e) { }
          pw.println("<h2> BYE  </h2>");
	}

}
