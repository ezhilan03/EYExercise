package EYExercise.day21;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StoredProcedureProg {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ey","root","Ee*180999");
		
		CallableStatement st = con.prepareCall("{call proc1(?,?)}"); // call procedure name(arguments specified in procedure);
		
		st.setInt(1,2); 
		
		st.registerOutParameter(2, Types.VARCHAR);
		
		st.execute();
		
		System.out.println(st.getString(2));
		
		st.close();
		con.close();
	}
}
