package InternExercise.test.day13;

import java.util.SortedMap;
import java.util.TreeMap;

public class Question23 {
	public static void main(String[] args) {
		TreeMap<String, String> myMap = new TreeMap<>();
		myMap.put("a", "apple");
		myMap.put("d", "date"); 
		 myMap.put("f", "fig");
		 myMap.put("p", "pear"); 
		 System.out.println("1st after mango: " + myMap.higherKey("f")); //least key greater than
		 System.out.println("1st after mango: " +myMap.ceilingKey("f")); //least key greater than or equal to
		 System.out.println("1st after mango: " +myMap.floorKey("f")); //greatest key less than or equal to
		 SortedMap<String, String> sub = new TreeMap<String, String>(); 
		 sub = myMap.tailMap("f");// a part or view of the map whose keys are greater than equal to the from_key in the parameter
		 System.out.println("1st after mango: "+sub.firstKey());
		 //sop 1 will only produce p.
	}
}
