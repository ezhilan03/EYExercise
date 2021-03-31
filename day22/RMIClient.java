package InternExercise.day22;

import java.rmi.Naming;

public class RMIClient {
	public static void main(String[] args) throws Exception{
		Buisness buisness = (Buisness)Naming.lookup("rmi://localhost:1099/myservice");
		System.out.println(buisness.getStockPrice("ey"));
	}
}
