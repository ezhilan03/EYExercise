package EYExercise.test.day13;

import java.util.TreeSet;

class Dog implements Comparable<Dog>{
	int size;
	Dog(int s) { size = s; }
	
	@Override
	public int compareTo(Dog o) {
		Integer i = (Integer)this.size;
		return i.compareTo((Integer)o.size);
	}
	} 
 
public class Question23B { 
	public static void main(String[] args) { 
		TreeSet<Integer> i = new TreeSet<Integer>(); 
		TreeSet<Dog> d = new TreeSet<Dog>(); 
 
		d.add(new Dog(1)); d.add(new Dog(2)); d.add(new Dog(1)); 
		i.add(1); i.add(2); i.add(1); 
		System.out.println(d.size() + " " + i.size()); 
	} 
} //answer is 2 2.