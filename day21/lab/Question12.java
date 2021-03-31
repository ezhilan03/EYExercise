package InternExercise.day21.lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;

public class Question12 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con  = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		System.out.println("enter 0 or 1 for flag");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int flag = br.read();
		
		CallableStatement st = con.prepareCall("{call proc(?)}");
		st.setInt(1,flag);
		
		st.executeUpdate();
		
		CallableStatement st2 = con.prepareCall("{call proc2(?)}");
		st2.registerOutParameter(1,2 );
		ResultSet rs = st2.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"\t"); //the columns starts from 1
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString("upass")+"\t");
			System.out.print(rs.getInt("flag")+"\n");
		}
	}
}
