package EYExercise.day13;

import java.util.Iterator;
import java.util.Stack;

public class CollectionsDemo7 {
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("Hello");
		s.push("World");
		s.push("Hi");
		s.push("There");
		
		System.out.println("Popped element is "+s.pop());
		
		Iterator<String> iter = s.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
