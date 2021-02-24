package day5; //the package should be first line in any program. Comments can be made before that.
import java.awt.*;
class MyClass{}



public class Day5 {
	public static void main(String[] arguments) {
		amethod(arguments); //cannot make a static reference to a non static method
	}
	public void amethod(String[] arguments) {
		System.out.println(arguments);
		System.out.println(arguments[1]);
	}
	void question1() {
		float f=1.3; //we should include f along the value because by default the value is double type.
		char c="a"; //should use single quotes for char type
		byte b=257; //the value is integer type
		boolean bo=null; // boolean can be true or false
		int i=10;
	}
	
	void question2() {
		
	}
}
