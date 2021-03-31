package InternExercise.day22;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements Buisness{
	
	public RMIServer() throws RemoteException{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getStockPrice(String stockName) throws RemoteException {
		if(stockName.equalsIgnoreCase("ey")) {
			return "ey stock price is... 1000";
		}
		return null;
		
	}
}
