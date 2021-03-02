package EYExercise.day9;

import java.util.Scanner;

public class Question40 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = scan.nextInt();
		Prime obj = new Prime();
		
		if(obj.checkPrime(num)) {
			System.out.println("Prime number");
		}		
		else {
			System.out.println("Not a prime number");
		}
		scan.close();
	}
}

class Prime {
	boolean checkPrime(int num) {
		if(num <= 0) {
			return false;
		}
		else {
			for(int i=2; i<num/2; i++) {
				if(num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}