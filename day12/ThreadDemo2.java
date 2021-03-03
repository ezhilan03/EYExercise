package EYExercise.day12;

public class ThreadDemo2 {
	public static void main(String[] args) {
		System.out.println("First line");
		new Thread(new Runnable() {
			@Override
			public void run() {
				method();
			}
		}).start();
//		new Thread(()->{
//			method();
//		}).start();
		try{Thread.sleep(1000);}catch(Exception e) {}
		System.out.println("Third line");
	}
	
	public static void method() {
		System.out.println("Second line");
	}
}
