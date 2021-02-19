package EYExercise.day1Exercise;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value... ");
		int num = sc.nextInt();
		String ans = PrimeNumber.findingPrime(num);
		System.out.println(ans);
		sc.close();
	}
	public static String findingPrime(int num) {
		int sqrt = (int) Math.sqrt(num) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (num % i == 0) {return "It is not a prime number"; }
		} return "It is a prime number";
	}
}
