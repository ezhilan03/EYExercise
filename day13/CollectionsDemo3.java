package EYExercise.day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo3 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello");
		System.out.println(set);
		
		Set<String> set2 = new TreeSet<String>((o1,o2)->o2.compareTo(o1));
		set2.add("Hello");
		set2.add("World");
		System.out.println(set2);
		
		Iterator<String> iter = set2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
