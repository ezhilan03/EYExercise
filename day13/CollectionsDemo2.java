package InternExercise.day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionsDemo2 {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();
		vec.add("Hello");
		vec.add("World");
		vec.add("Hi");
		System.out.println(vec);
		
		Enumeration<String> enu = vec.elements();
		Iterator<String> iter = vec.iterator();
		
		vec.add("There");
		while(enu.hasMoreElements()) {
			System.out.print(enu.nextElement()+" ");
		}
//		while(iter.hasNext()) { // throws error.
//			System.out.println(iter.next()+" ");
//		}
		
		
	}
}
