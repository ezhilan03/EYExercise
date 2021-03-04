package EYExercise.day13;
import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception{
		ExecutorService es = Executors.newFixedThreadPool(1);
//		Future<Integer> future = es.submit(new MyCallable());
//		int num = future.get();
//		System.out.println("The number is "+num);
		
		Future<String> future = es.submit(()->{
			return "Hello world";
		});
		System.out.println(future.get());
	}
}

class MyCallable implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		
		return 10000;
	}
}