package InternExercise.day21.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Question6 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
			
			Statement st = con.createStatement();
			
			st.execute("insert into users values(9,'a','a',0)");
			st.execute("delete from users where uname='a'");
			
			System.out.println("successfull");
			st.close();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
