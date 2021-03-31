package InternExercise.test.day13;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question16 { // this will throw exception at runtime as tree set tries to sort in order but the elements are not comparable.
	public static void main(String[] args) { 
		Set set = new TreeSet();
		set.add("2");
		set.add(3);
		set.add("1");
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
	}
}
