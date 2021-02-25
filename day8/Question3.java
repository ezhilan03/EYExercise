package EYExercise.day8;
import java.util.Date;

public class Question3 {
	public static void main(String[] args) {
		Worker worker = new Worker();
		SalesPerson salesPerson = new SalesPerson();
		SalesManager salesManager = new SalesManager();
		TerritoryManager territoryManager = new TerritoryManager();
		System.out.println("date of joinin of worker is "+worker.date);
		System.out.println("date of joinin of SalesPerson is "+salesPerson.date);
		System.out.println("date of joinin of TerritoryManager is "+territoryManager.date);
		System.out.println("date of joinin of salesManager is "+salesManager.date);
	}
}

abstract class Employee{
	
}

class Worker extends Employee{
	Date date;
	public Worker() {
		this.date=new Date();
	}
}

class SalesPerson extends Employee{
	Date date;
	public SalesPerson() {
		this.date=new Date();
	}
}

class SalesManager extends SalesPerson{
	Date date;
	public SalesManager() {
		this.date=new Date();
	}
}

class TerritoryManager extends SalesManager{
	Date date;
	public TerritoryManager() {
		this.date=new Date();
	}
}