package InternExercise.day9;
import java.util.Scanner;

public class Question37 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number");
		int num = scan.nextInt();
		int sum=0;
		int temp = num;
		int n;
		
		while(num > 0) {
			n = num%10;
			sum+=n;
			num=num/10;
		}
		
		System.out.println("Sum of digits of "+temp+" :"+sum);
	}
}
