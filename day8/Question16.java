package InternExercise.day8;

public class Question16 {
	public static void main(String[] args) {
		new Chrome().main(args);
	}
}
class X {
	void do2() {
		System.out.println("this is parent class do2");
		}
	void do1() {
		System.out.println("this is parent class do1");
		}
	} 
class Y extends X { 
	void do2() {
		System.out.println("this is child class do2");
		}
	} 
class Chrome { 
	public static void main(String [] args) {
		X x1 = new X();
		X x2 = new Y();
		Y y1 = new Y();
		x2.do2(); // even if the instance is created for the class Y, the object refers to class X at compile time. So we should at least declare the method do2 in parent class.
		}  
	} 