package InternExercise.day12;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadResourceManagement {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			Laptop laptop = Company.getLaptop("ram");
			//Company.closeLaptop();
			Laptop laptop2 = Company.getLaptop("ram");
		});
		es.execute(()->{
			Laptop laptop = Company.getLaptop("som");
		});
		es.shutdown();
	}
}

class Company{
	private static ThreadLocal<Laptop> locker = new ThreadLocal<>();
	public static Laptop getLaptop(String name) {
		Laptop laptop =(Laptop)locker.get();
		if(laptop==null) {
			laptop=new Laptop(name);
			locker.set(laptop);
		}
		return laptop;
	}
	public static void closeLaptop() {
		Laptop laptop = (Laptop)locker.get();
		if(laptop!=null)
			locker.remove();
	}
}

class Laptop{
	String name;
	public Laptop(String name) {
		System.out.println("Laptop created");
		this.name=name;
	}
	@Override
	public String toString() {
		return "this lap belongs to "+name;
	}
}