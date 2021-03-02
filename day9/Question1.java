package EYExercise.day9;
import java.util.Scanner;
public class Question1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter two variables");
		int a =scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		swap(a,b);
	}
	public static void swap(int a,int b) {
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);
	}
}
