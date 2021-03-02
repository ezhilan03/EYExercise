package EYExercise.day9;
import java.util.Scanner;

public class Question43 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int a[] = new int[5];
		System.out.println("Enter the integer array");
		for(int i=0; i<5; i++) {
			a[i] = scan.nextInt();
		}
		
		int biggest=Integer.MIN_VALUE;
		int lowest=Integer.MAX_VALUE;
		
		for(int i=0; i<5; i++) {
			if(a[i] > biggest)
				biggest=a[i];
			if(a[i] < lowest)
				lowest = a[i];
		}
		
		System.out.println("Biggest: "+biggest);
		System.out.println("Lowest: "+lowest);
		scan.close();
	}

}