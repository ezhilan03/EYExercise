package EYExercise.test.day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question3 {
	public static void main(String[] args) {
		before(); //before method throws ClassCast Exception
	}
	public static void before() {
		Set set = new TreeSet(); //The elements in TreeSet should be of comparable type. Here string and integers are not comparable.
		set.add("2");             //this throws run time error.
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		while (it.hasNext())
			System.out.print(it.next() instanceof String);
		}
}

