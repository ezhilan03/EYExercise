package EYExercise.test.day13;
import java.util.*; 

/*
 * If two objects are equal according to their equals() method and hashCode() method, then they are considered same object
 * and they are inserted only once in this hashmap.
 * So it prints 3 if the hashcode is commented and 2 if it used.
 */

class Question5 {
	public static void main(String[] args) {
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday"); 
		ToDos t2 = new ToDos("Monday"); 
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "doLaundry");
		m.put(t2, "payBills");
		m.put(t3, "cleanAttic"); 
		System.out.println(m.size());
		System.out.println(m);
	}
	} 
class ToDos{ 
	String day;
	ToDos(String d) {
		day = d; 
		} 
	public boolean equals(Object o) {
		return ((ToDos)o).day == this.day;
	}
	 public int hashCode() { return 10; }  
}

