package EYExercise.test.day13;

import java.util.*;

public class Question9 {
	public static void main(String[] args) {
		Object o = new Object();
		
//		Set s = new HashSet(); //this compiles and runs.
//		Set s = new TreeSet(); //this compiles but throws run time Exception.
		LinkedHashSet s = new LinkedHashSet(); //this complies and run.
		
		s.add("0");
		s.add(0);
		
	}
}
