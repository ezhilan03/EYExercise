package EYExercise.assignment;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

import EYExercise.day22.invoicejdbc.CustomerDetailsDTO;
import EYExercise.day22.invoicejdbc.InvoiceMasterDTO;
import EYExercise.day22.invoicejdbc.ItemDetailsDTO;
import EYExercise.day22.invoicejdbc.ItemTransactionDTO;

public interface Invoice extends Remote{
	
	public void createInvoice(InvoiceMasterDTO inv1, CustomerDetailsDTO customer1, ItemTransactionDTO transac1)throws Exception;
	public void createExcel(int invNo)throws Exception;
	public void createPdf(int invNo)throws Exception;
	public void createItem(ItemDetailsDTO item1)throws Exception;
	public LocalDateTime calculateDate(int distance,int speed,int ihours,int iminutes,int iseconds) throws Exception;
	public int getLengthOfTable()throws Exception;

}