package EYExercise.day9;
import java.util.Scanner;

public class Question33 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the range");
		int n = scan.nextInt();
		scan.close();
		System.out.println("Even numbers upto "+n);
		for(int i=1; i<=n; i++) {
			if(i%2 == 0) {
				System.out.println(i+"  ");
			}
		}
	}

}
