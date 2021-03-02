package EYExercise.day9;
import java.util.Scanner;

public class Question29 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a letter");
		char c = scan.next().charAt(0);
		scan.close();
		switch(c) {
		case 'a':
			System.out.println("It is a vowel");
			break;
		case 'e':
			System.out.println("It is a vowel");
			break;
		case 'i':
			System.out.println("It is a vowel");
			break;
		case 'o':
			System.out.println("It is a vowel");
			break;
		case 'u':
			System.out.println("It is a vowel");
			break;
		default:
			System.out.println("It is not a vowel");
			break;
		}
	}
}
