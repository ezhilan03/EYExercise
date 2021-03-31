package InternExercise.day21.lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
			
			//Statement st = con.createStatement();
			
//			Statement st= con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			//This type of ResultSet is insensitive to the changes that are made in the database i.e. the modifications done in the database are not reflected in the ResultSet. we can use scroll sensitive
			// concur read only - once you get a ResultSet object you cannot update its contents.
			
			Statement st= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
			
			ResultSet rs = st.executeQuery("select * from users");
			
//			while(rs.next()) {
//				
//			}
			rs.afterLast(); //instead of iterating through,  we can use this func.
			while(rs.previous()) {
			
				System.out.print(rs.getInt(1)+"\t"); //the columns starts from 1
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString("upass")+"\t");
				System.out.print(rs.getInt("flag")+"\n");
			}
			
		st.close();
		con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}
