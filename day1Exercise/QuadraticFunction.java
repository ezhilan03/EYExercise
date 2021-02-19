package EYExercise.day1Exercise;

public class QuadraticFunction {
	
	private int a,b,c;
	
	QuadraticFunction(){
		a=1;
		b=1;
		c=1;
	}
	
	QuadraticFunction(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int extractinga() {
		return a;
	}
	
	public int extractingb() {
		return b;
	}
	
	public int extractingc() {
		return c;
	}
	
	
	public void modifying(int a,int b,int c) {
		this.a = a;
		this.b = b;
		this.c = c;		
	}
	
	public int compute(int x) {
		return (a*(x*x))+(b*x)+c;
	}
	
	public static void main(String[] args) {
		QuadraticFunction obj1 = new QuadraticFunction();
		System.out.println(obj1.extractinga()+" "+obj1.extractingb()+" "+obj1.extractingc());
		QuadraticFunction obj2 = new QuadraticFunction(1,2,3);
		System.out.println(obj2.extractinga()+" "+obj2.extractingb()+" "+obj2.extractingc());
		obj2.modifying(4,5,6);
		System.out.println(obj2.extractinga()+" "+obj2.extractingb()+" "+obj2.extractingc());
		System.out.println(obj2.compute(2));
		
	}
}
