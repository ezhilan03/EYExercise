package EYExercise.day9;
import java.util.Scanner;

public class Question34 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the range");
		int n = scan.nextInt();
		int sum=0;
		double avg;
		for(int i=1; i<=n; i++) {
			if(i%2 != 0) {
				sum += i;
			}
		}
		avg = sum/n;
		System.out.println("Average of odd numbers upto "+n+": "+avg);
	}
}
