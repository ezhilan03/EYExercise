package InternExercise.day12; // the program is the main thread

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public ThreadDemo() {
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(new ThreadJob());
		es.shutdown();
//		Thread t = new Thread(new ThreadJob());
//		t.start();//child thread waits in the area semaphore
				  //If he main thread is interrupted, child thread starts.	
	}
	public static void main(String[] args) throws Exception{ 
		new ThreadDemo();
		Thread t = Thread.currentThread();
		t.setName("King");
		t.setPriority(10);
		System.out.println(t);
//		System.exit(1); // to kill main thread
		for(int i=0;i<5;i++) {
			System.out.println(i);
			Thread.sleep(1000); //throws interrupted exception
		}
	}
}
class ThreadJob implements Runnable{
	@Override
	public void run() {
		System.out.println("Child thread is working now");
		
	}
}
