package InternExercise.day13;

import java.util.ArrayList;

public class GenericsDemo2 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			arr.add(i);
		}
		System.out.println(arr);
	}
}
