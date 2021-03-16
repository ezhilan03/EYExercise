package EYExercise.day21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class PreparedStatementProg {
	public static void main(String[] args) throws Exception{
		//For dynamic querying, instead of normal statement we use prepare statement.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		String query = "Select * from users where uid=? and uname=?";//query string should be declared before.
		
		PreparedStatement st = con.prepareStatement(query);
		while(true) {
			Scanner scan  = new Scanner(System.in);
			System.out.println("Enter the id of user ");
			int uid = scan.nextInt();
			System.out.println("Enter the name of user ");
			String uname = scan.next();
			
			st.setInt(1, uid); // (to denote which question mark, value)
			st.setString(2, uname);
			
		ResultSet rs = st.executeQuery();
		
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

		}
		}
	}
}
