package InternExercise.day9;
import java.util.Scanner;

public class Question42 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter integer array");
		int a[] = new int[5];
		
		for(int i=0; i<5; i++) {
			a[i] = scan.nextInt();
		}
		for(int i=4; i>=0; i--) {
			System.out.print(a[i]+" ");
		}
	}
}