package InternExercise.day21.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

public class Question13 {
	public static void main(String st1[]) throws Exception 
	 { 
		Class.forName("com.mysql.cj.jdbc.Driver"); 

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		Enumeration e=DriverManager.getDrivers(); 
		System.out.println("time taken for login " +DriverManager.getLoginTimeout()); 
		while(e.hasMoreElements()) 
		{ 
			System.out.println(e.nextElement()); 
		} 
	 } 

}
