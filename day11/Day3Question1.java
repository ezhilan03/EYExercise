package InternExercise.day11;

public class Day3Question1 {
	public static void main(String[] args) {
		SalesPerson employee1 = new SalesPerson();
		SalesManager employee2 = new SalesManager();
		SalesTerritory employee3 = new SalesTerritory();
		Manager employee4 = new Manager();
		Worker employee5 = new Worker();
		
		employee1.work();
		employee1.pay(100);
		
		employee2.work();
		employee2.pay(1000);
		
		employee3.work();
		employee3.pay(1000);
		
		employee4.work();
		employee4.pay(10000);
		
		employee5.work();
		employee5.pay(10);
	}
}

interface Employee{
	public void work();
}

abstract class Sales implements Employee{
	abstract public void pay(int salary);
}

abstract class Prod implements Employee{
	abstract public void pay(int salary);
}

class SalesPerson extends Sales{
	@Override
	public void work() {
		System.out.println("SalesPerson is working");
	}
	@Override
	public void pay(int salary) {
		System.out.println("SalesPerson's salary is "+salary);
		
	}
}
class SalesManager extends Sales{
	@Override
	public void work() {
		System.out.println("SalesManager is working");
		
	}
	@Override
	public void pay(int salary) {
		System.out.println("SalesManager's salary is "+salary);
		
	}
}
class SalesTerritory extends Sales{
	@Override
	public void work() {
		System.out.println("SalesTerritory is working");
		
	}
	@Override
	public void pay(int salary) {
		System.out.println("SalesTerritory's salary is "+salary);
		
	}
}
class Manager extends Sales{
	@Override
	public void work() {
		System.out.println("Manager is working");
		
	}
	@Override
	public void pay(int salary) {
		System.out.println("Manager's salary is "+salary);
		
	}
}

class Worker extends Prod{
	@Override
	public void work() {
		System.out.println("Worker is working");
		
	}
	@Override
	public void pay(int salary) {
		System.out.println("Worker's salary is "+salary);
		
	}
}