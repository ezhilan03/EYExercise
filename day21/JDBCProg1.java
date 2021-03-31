package InternExercise.day21;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;

public class JDBCProg1 {
	public static void main(String[] args) throws Exception{
		//Step1
		//Load - Register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Step 2 - Establish a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999"); // (url,username,pass);
		System.out.println(con);
		
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println(dbmd.getDatabaseProductName());
		System.out.println(dbmd.getSchemas());
		
	}
}
