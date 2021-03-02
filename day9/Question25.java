package EYExercise.day9;
import java.util.Scanner;
public class Question25 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter three numbers");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		findMax(a,b,c);
	}
	static void findMax(int a,int b, int c) {
		if(a>=b && a>=c) {
			System.out.println(a+" is the largest number");
		}
		else if(b>=a && b>=c) {
			System.out.println(b+" is the largest number");
		}
		else {
			System.out.println(c+" is the largest number");
		}
	}
}

//26th question is same as that of 1st question.

//27 Sequential,Selection(if,if/else,switch),Repetition(for,while,do/while).