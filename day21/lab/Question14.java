package EYExercise.day21.lab;

import java.sql.Connection;

public class Question14 {
	public static void main(String[] args) throws Exception{
		Connection con=ConnectionUtility.createConnection(); 
		PreparedStatement ps=con.prepareStatement("select * from users where uid=?"); 
		Scanner scan=new Scanner(System.in); 
		while(true) { 
			System.out.println("Please enter a uid...:"); 
			int uid=Integer.parseInt(scan.next()); 
			ps.setInt(1, uid); 
			ResultSet rs=ps.executeQuery(); 
			if(rs.next()) { 
				System.out.println(uid+"..:"+rs.getString("uname")); 
			} 
		 } 
	} 
}
