package EYExercise.day1Exercise;
import java.util.Arrays;
public class Index {
	public static int findIndex(int[] arr, int t) 
    {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==t)
				return i;
		}
		return -1;
    } 
	public static void main(String[] args) {
		int[] intArray = {4,5,6,1,2,3};
		int idx= findIndex(intArray, 2);
		System.out.println("The index is "+idx);
	}
}
