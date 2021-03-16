package EYExercise.day21.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Question4 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
			
			Statement st = con.createStatement();
			
			st.executeUpdate("insert into users values(4,'a','a',1)");
			st.executeUpdate("insert into users values(5,'a','a',1)");
			st.executeUpdate("insert into users values(6,'a','a',1)");
			st.executeUpdate("insert into users values(7,'a','a',1)");
			st.executeUpdate("insert into users values(8,'a','a',1)");
			
			st.close();
			con.close();
			System.out.println("successfull");
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
