package EYExercise.day9;

public class Question38 {
	public static void main(String[] args) {
		Fibonacci obj = new Fibonacci();
		obj.printFibonacci(6);
	}
}

class Fibonacci {
	void printFibonacci(int n) {
		int a=0;
		int b=1;
		int c=a+b;
		System.out.print(a+" "+b+" "+c+" ");
		
		for(int i=1; i<=n-3; i++) {
			a=b;
			b=c;
			c=a+b;
			System.out.print(c+" ");
		}
		
	}
}