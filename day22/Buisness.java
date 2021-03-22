package EYExercise.day22;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Buisness extends Remote{
	public String getStockPrice(String stockName)throws RemoteException;
}
