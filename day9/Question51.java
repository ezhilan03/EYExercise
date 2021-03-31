package InternExercise.day9;

public class Question51 {

	public static void main(String[] args) {
		Child c = new Child();
		c.print(5);
	}
}

class Parent {
	void print(int num) {
		System.out.println("Value of num in Parent: "+num);
	}
}

class Child extends Parent {
	void print(int num) {
		System.out.println("Value of num in Child: "+num); 
		super.print(10);
		}
}