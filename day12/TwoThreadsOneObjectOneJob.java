package EYExercise.day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//two threads one object and two jobs
public class TwoThreadsOneObjectOneJob {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReservationCounter rc = new ReservationCounter();
		es.execute(()->{
			Thread.currentThread().setName("Mr.x");
			synchronized(rc) {
				rc.book(1000);
				System.out.print("");
				rc.getChange();
			}
		});
		es.execute(()->{
			Thread.currentThread().setName("Mr.y");
			synchronized(rc) {
				rc.book(500);
				rc.getChange();
			}
		});
		es.shutdownNow();
	}
}

class ReservationCounter{
	int money;
	 public void book(int money) {
		this.money=money;
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Thread "+name + " booked ticket for "+money);
	}

	 public void getChange() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Thread "+name + " is given change of "+(money-100));
	}
}