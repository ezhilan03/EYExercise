package InternExercise.day21.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question8 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
			
			Statement st = con.createStatement();
			
			st.executeUpdate("drop table table1");
			System.out.println("Dropped successfully");
			
			ResultSet rs = st.executeQuery("select * from users");
			
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t"); //the columns starts from 1
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString("upass")+"\t");
				System.out.print(rs.getInt("flag")+"\n");
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
}