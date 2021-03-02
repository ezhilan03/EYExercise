package EYExercise.day9;

public class Question18 {
	public static void main(String[] args) {
		int a = 1;   
		int b = 2;    
		int c;  
		int d;   
		c = ++b;
		d = a++;  
		c++;
		System.out.println("Value of c is "+c);
		System.out.println("Value of d is "+d);
		booleanCheck();
		
	}
	static void booleanCheck() {
		int a = 4; 
		int b = 1;
		Boolean c = a<b;
		System.out.println("the value of boolean c is "+c);
	}
}

// All Statements in question 20 are true depending on the data type of "done".