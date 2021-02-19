package EYExercise.day1Exercise;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Occurence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int n = sc.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Enter the element to be searched");
		int target = sc.nextInt();
		int occurence = 0,flag=0;
		List<Integer> positions = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==target) {
				flag=1;
				occurence+=1;
				positions.add(i);
			}
		}
		if(flag==1) {
			System.out.println("The element is present");
			System.out.println("The element occurs "+occurence);
			System.out.println("The positions are "+positions);
		}
	}
}
