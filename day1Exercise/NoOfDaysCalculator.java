package EYExercise.day1Exercise;
// 21 
import java.util.Scanner;

public class NoOfDaysCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the month");
		String month = sc.nextLine();
		
		switch(month) {
		case "january":{
			System.out.println("The number of days is  31");
			break;}
		case "february":{
			System.out.println("Enter the year");
			int year = sc.nextInt();
			System.out.println("The number of days is "+februaryMonthCalculator(year));
		}	
		case "march":{
			System.out.println("The number of days is  31");
			break;}
		case "april":{
			System.out.println("The number of days is  30");
			break;}
		case "may":{
			System.out.println("The number of days is  31");
			break;}
		case "june":{
			System.out.println("The number of days is  30");
			break;}
		case "july":{
			System.out.println("The number of days is  31");
			break;}
		case "august":{
			System.out.println("The number of days is  31");
			break;}
		case "september":{
			System.out.println("The number of days is  30");
			break;}
		case "october":{
			System.out.println("The number of days is  31");
			break;}
		case "november":{
			System.out.println("The number of days is  30");
			break;}
		case "december":{
			System.out.println("The number of days is  31");
			break;}
		default:{
			System.out.println("Enter valid month");
			break;
		}
		}
	}
	public static int februaryMonthCalculator(int year) {
		int days = (((year%4==0) && (year%100!= 0)) || (year%400==0))?29:28;
		return days;
	}
}
