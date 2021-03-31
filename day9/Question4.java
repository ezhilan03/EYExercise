package InternExercise.day9;
import java.util.Scanner;
public class Question4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string");
		char[] arr = scan.nextLine().toCharArray();
		scan.close();
		count(arr);
	}
	@SuppressWarnings("deprecation")
	public static void count(char[] arr) {
		int integer=0;
		int space=0;
		int letter=0;
		int other=0;
		for(int i=0;i<arr.length;i++) {
			if(Character.isAlphabetic(arr[i])) {
				letter++;
			}
			else if(Character.isDigit(arr[i])) {
				integer++;
			}
			else if(Character.isSpace(arr[i])) {
				space++;
			}
			else
				other++;
		}
		System.out.println("The number of letters "+letter);
		System.out.println("The number of integers "+integer);
		System.out.println("The number of spaces "+space);
		System.out.println("The number of other characters "+other);
	}
}
