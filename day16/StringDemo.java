package EYExercise.day16;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringDemo {
	public static void main(String[] args) {
		//Strings are non mutable
		/*If we do manipulation on normal string for every manipulation, new object is created.
		 * If we want to do manipulation in string we can go for:
		 * StringBuilder (non synchronized) but fast
		 * StringBuffer  (synchronized) but slow
		 * StringJoiner  (non synchronized) but has more methods for formatting
		 */
		String s = "Hello World";
		String ss = new String("Hello World"); //two representation- one in heap and one in stack.
		
		StringBuilder sb = new StringBuilder("Hello World ");
		sb.append("form string builder");
		System.out.println(sb);
		
		StringBuffer sbf = new StringBuffer("Hello World");
		sbf.append("form string buffer");
		System.out.println(sbf);
		
		StringJoiner sj = new StringJoiner(","); //should give format here.
		System.out.println(sj);
		sj.add("Hello");
		sj.add("World");
		System.out.println(sj);
		
		StringJoiner sj2 = new StringJoiner(",","[","]"); 
		sj2.add("Hello");
		sj2.add("World");
		sj2.add("Hi");
		sj2.add("there");
		System.out.println(sj2);
		
		StringTokenizer st = new StringTokenizer(sj2.toString(),",");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
