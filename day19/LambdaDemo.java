package InternExercise.day19;

public class LambdaDemo {
	public static void main(String[] args) {
		
		//anonymous inner class:
		MyInterface inter = new MyInterface() {
			@Override
			public void action(int num) {
				System.out.println("this action is coming from anonymous inner class "+num);
				
			}
		};
		inter.action(10);
		
		//lambda
		MyInterface inter2 = (int num)->{
			System.out.println("This is coming from lambda "+num);
		};
		inter2.action(20);
		
		//method referencing
		MyInterface inter3 = new LambdaDemo()::myAction;
		inter3.action(30);
		
	}
	public void myAction(int num) {
		System.out.println("This is coming from method referencing "+num);
	}
}

@FunctionalInterface
interface MyInterface{
	public void action(int num);
}
