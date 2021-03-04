package EYExercise.day13;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CollectionsDemo8 {
	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<String>(); //As the Queue is an interface, it cannot be instantiated. We need some concrete classes to implement the functionality of the Queue interface. Two classes implement the Queue interface i.e. LinkedList and PriorityQueue.
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		q.add("d");
		System.out.println("the removed element is "+q.remove());
		
		Iterator<String> iter = q.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
