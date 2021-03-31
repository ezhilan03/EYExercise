package InternExercise.test.day13;

import java.util.LinkedHashSet;

class Turtle {  //if there's no hash code it returns 3. And if there's hashcode which returns same value for every object, the answer is 2.
	int size; 
	public Turtle(int s) { size = s; } 
	public boolean equals(Object o) { return (this.size == ((Turtle)o).size); } 
	 public int hashCode() { return size/5; } 
} 
public class Question20 { 
	public static void main(String[] args) { 
		LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>(); 
		t.add(new Turtle(1));
		t.add(new Turtle(2));
		t.add(new Turtle(1)); 
		System.out.println(t.size()); 
	} 
} 
