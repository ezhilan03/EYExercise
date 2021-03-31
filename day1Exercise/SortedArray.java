package InternExercise.day1Exercise;
import java.util.Arrays;
import java.util.Collections;

public class SortedArray {
	public static void main(String[] args) {
		Integer[] arr= {3,2,6,5,1,4};
		Arrays.sort(arr);
		System.out.println("Ascending order Sorted array is ");
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println("Descending order Sorted array is ");
		System.out.println(Arrays.toString(arr));
	}
}
