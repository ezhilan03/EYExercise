package EYExercise.day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadDemo {
	public DaemonThreadDemo() {
//		new Thread(()->{
//			while(true) {
//				System.out.println("child thread is running");
//			}
//		}).start();
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				System.out.println("Child thread is running");
			}
		});
	}
	public static void main(String[] args) {
		
		new DaemonThreadDemo();
		System.out.println("Main thread started");
		try {Thread.currentThread().sleep(10);}catch(Exception e) {}
		Thread.currentThread().setDaemon(true);
		System.exit(1);
	}
	
}
