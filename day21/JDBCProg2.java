package InternExercise.day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCProg2 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		Statement st = con.createStatement();
		
//		String query = "insert into users value(3,'ezhil','fox',1)";
//		
//		int noOfRowsInserted = st.executeUpdate(query);
//		System.out.println("No of rows inserted is :"+noOfRowsInserted);
		
		String query2 = "Select * from users";
		boolean b = st.execute(query2);
		//execute will return true if the return is result set.
		System.out.println("This query returned result set : "+b);
	}
}
