package InternExercise.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;


class Employee implements Comparable<Employee>{
	String name;
	public Employee(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return "Name is "+this.name;
	}
	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
}

public class CollectionsDemo {
	public static void main(String[] args) {
		//List<String> arr2 = new ArrayList<String>(5);
		List<Employee> arr = Arrays.asList(new Employee("ram"),new Employee("som"),new Employee("janu"),new Employee("ram"));
//		arr.add(new Employee("ram"));
//		arr.add(new Employee("som"));
//		arr.add(new Employee("hello"));
//		arr.add(new Employee("world"));
		System.out.println(arr);
		System.out.println(arr.get(1).name);
		System.out.println(arr.contains(new Employee("ram")));
		System.out.println(arr.size());
		int size = arr.size();
		for(int i=0;i<size;i++) { // this is a bad practice
			System.out.print(arr.get(i).name+" ");
		}
		System.out.println();
		
		for(Employee s:arr) { // this is a better practice.But,
			System.out.print(s.name+ " ");
		}
		System.out.println();

		Iterator<Employee> iter = arr.iterator(); // this is the best practice. But this is scroll insensitive.
		while(iter.hasNext()) { //we cannot use the same iter cursor more than once.
			System.out.print(iter.next().name+" ");
		}
		System.out.println();
		
		ListIterator<Employee> listIter = arr.listIterator();
		while(listIter.hasNext()) {
			System.out.print(listIter.next().name+" ");
		}
		System.out.println();
		
		while(listIter.hasPrevious()) {
			System.out.print(listIter.previous().name+" ");
		}
		System.out.println();
		
		Collections.sort(arr);
		System.out.println("The sorted array is "+arr);
		
		Collections.sort(arr,new MyComparator());
		System.out.println("The reverse sorted array is "+arr);
		
		Collections.sort(arr,(o1,o2)->{return o2.compareTo(o1);});
		System.out.println("The reverse sorted array using lambda is "+arr);
		
		Stream<Employee> stream = arr.stream();
		stream.filter((emp)->emp.equals("world")).forEach(System.out::println);;
		//stream.filter((emp)->{return emp.equals("world");}).forEach(System.out::println);
	}
}

class MyComparator implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.compareTo(o1);
	}

}

