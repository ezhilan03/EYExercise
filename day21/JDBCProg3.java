package InternExercise.day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCProg3 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		Statement st = con.createStatement();
		
		String query = "Select * from users";
		
		ResultSet rs = st.executeQuery(query);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int noOfColumns = rsmd.getColumnCount();	
		for(int i=1;i<=noOfColumns;i++) {
			System.out.print(rsmd.getColumnLabel(i)+"\t");
		}
		System.out.println();
		
		while(rs.next()) {
			for(int i=1;i<=noOfColumns;i++) {
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
//			System.out.print(rs.getInt(1)+"\t"); //the columns starts from 1
//			System.out.print(rs.getString(2)+"\t");
//			System.out.print(rs.getString("upass")+"\t");
//			System.out.print(rs.getInt("flag")+"\n");
		}
	}
}
