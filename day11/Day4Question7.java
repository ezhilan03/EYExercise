package InternExercise.day11;

import java.util.Scanner;

public class Day4Question7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			double numerator = 0;
			String numeratorString = "";
			try {
				System.out.println("Enter Numerator");
				numeratorString =  scan.next();
				numerator = Double.parseDouble(numeratorString);
				System.out.println("Enter Divisor");
				double divisor = scan.nextInt();
		
				System.out.println(numerator/divisor);
			}catch(NumberFormatException nfe) {
				if(numeratorString.toLowerCase().startsWith("q")) {
					break;}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
