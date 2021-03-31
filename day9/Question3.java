package InternExercise.day9;
import java.util.Scanner;
public class Question3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		char[] arr = scan.nextLine().toCharArray(); 
		scan.close();
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
	}
}
