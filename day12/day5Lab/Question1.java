package InternExercise.day12.day5Lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question1 {
	public static void main(String[] args) {
		ExecutorService es  = Executors.newFixedThreadPool(2);
		Question1 obj = new Question1();
		es.execute(()->{
			synchronized(obj) {
				obj.printEven();
			}
		});
		es.execute(()->{
			synchronized(obj) {
				System.out.println();
				obj.printOdd();
			}		
		});
	}
	
	public void printEven() {
		System.out.print("The even numbers are  ");
		for(int i=2;i<=100;i+=2) {
			System.out.print(" "+i);
			}	
		}
	public  void printOdd() {
		System.out.print("The odd numbers are  ");
		for(int j=1;j<100;j+=2) {
			System.out.print(" "+j);
		}
	}
}
