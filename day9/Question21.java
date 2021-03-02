package EYExercise.day9;

public class Question21 {
	public static void main(String[] args) {
		boolean a = true, b = false  ;
		boolean c = a | b; 
		boolean d = a & b; 
		boolean e = a ^ b;  
		boolean f = (! a & b) | (a &! b);
		boolean g =! a; 
		System.out.println(c+" "+d+" "+e+" "+f+" "+g);
		question22();
	}
	static void  question22() {
		int a = 20, b = 10;  
		int x = a>b? a:b;
		System.out.println("value od x is "+x);
	}
}
