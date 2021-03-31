package InternExercise.day12;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TwoThreadsOneObject {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Gun gun = new Gun();
		es.execute(()->{
			for(int i=0;i<5;i++) {
				gun.fillGun();
			}
		});
		es.execute(()->{
			for(int j=0;j<5;j++) {
				gun.shootGun();
			}
		});
		es.shutdown();
	}
}

class Gun{
	boolean flag;
	
	synchronized public void fillGun() {
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		else {
			System.out.println("Filling gun");
			flag=true;
			notify();
		}
	}
	
	synchronized public void shootGun() {
		if(!flag) {
			try{wait();}catch(Exception e) {}
		}
		else {
			System.out.println("Shooting gun");
			flag=false;
			notify();
		}
	}
}