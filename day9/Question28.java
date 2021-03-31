package InternExercise.day9;

import java.util.Scanner;

public class Question28 {
	public static void main(String[] args) {
		System.out.println("Enter the month");
		Scanner scan = new Scanner(System.in);
		String month = scan.next();
		scan.close();
		if(month.equalsIgnoreCase("January") || month.equalsIgnoreCase("December")) {
			System.out.println("It is Winter season");
		}
		else if(month.equalsIgnoreCase("February") || month.equalsIgnoreCase("March")) {
			System.out.println("It is Spring season");
		}
		else if(month.equalsIgnoreCase("April") || month.equalsIgnoreCase("May") || month.equalsIgnoreCase("June")) {
			System.out.println("It is Summer season");
		}
		else if(month.equalsIgnoreCase("July") || month.equalsIgnoreCase("August") || month.equalsIgnoreCase("September")) {
			System.out.println("It is Monsoon season");
		}
		else if(month.equalsIgnoreCase("November")) {
			System.out.println("It is Autumn");
		}
	}
}