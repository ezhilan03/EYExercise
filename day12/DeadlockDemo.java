package EYExercise.day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Crane crane = new Crane();
		Frog frog = new Frog();
		es.execute(()->{
			crane.eat(frog);
		});
		es.execute(()->{
			frog.escape(crane);
		});
		es.shutdown();
	}
}

class Crane{
	synchronized public void eat(Frog frog) {
		frog.leaveCrane();
		System.out.println("swaha");
	}
	synchronized public void spit() {
		
	}
}

class Frog{
	synchronized public void escape(Crane crane){
		crane.spit();
	}
	synchronized public void leaveCrane() {
		
	}
}