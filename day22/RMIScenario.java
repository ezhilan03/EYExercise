package InternExercise.day22;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIScenario {
	public static void main(String[] args) throws Exception{
		LocateRegistry.createRegistry(1099); //registry service
		RMIServer rmiService = new RMIServer();
		
		System.out.println("Server ready");
		Naming.bind("rmi://localhost:1099/myservice", rmiService);
	}
}
