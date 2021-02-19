package EYExercise.day1Exercise;
import java.util.Scanner;
import java.text.NumberFormat;

public class Number2WordConverter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number");
		int num = sc.nextInt();
		System.out.println(conversion(num));
	}
	public static String[] units = { "", "One", "Two", "Three", "Four","Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve","Thirteen", "Fourteen",
			"Fifteen", "Sixteen", "Seventeen","Eighteen", "Nineteen" };
	public static String[] tens = { 
			"", "",	"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy","Eighty", 	
			"Ninety" 
			};

	public static String conversion(int num) {
		if(num<0) 
			return "Minus " + conversion(-num); 

		if(num<20) {return units[num]; }

		if(num<100) {
			return tens[num/10] + ((num%10!=0) ? " " : "") + units[num%10];
		}

		if(num<1000) {
			return units[num/100] + " Hundred" + ((num%100!=0) ? " " : "") + conversion(num%100);
		}

		if(num<100000) {
			return conversion(num/1000) + " Thousand" + ((num%10000!= 0) ? " " : "") + conversion(num%1000);
		}

		if(num<10000000) {
			return conversion(num/100000) + " Lakh" + ((num%100000!=0) ? " " : "") + conversion(num%100000);
		}

		return conversion(num / 10000000) + " Crore" + ((num % 10000000 != 0) ? " " : "") + conversion(num % 10000000);
	}
}
