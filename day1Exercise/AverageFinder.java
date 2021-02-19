package EYExercise.day1Exercise;

import java.util.Scanner;

public class AverageFinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of values... ");
		int n = sc.nextInt();
		int[] array=new int[n];
		System.out.println("Enter the values");
		for(int i=0;i<n;i++) {
			array[i]=sc.nextInt();
		}
		double ans = findingAverage(n,array);
		System.out.println("The average is..."+ans);
		sc.close();
	}
	public static double findingAverage(int n,int[] array) {
		int total=0;
		for(int i=0;i<n;i++) {
			total+=array[i];
		}
		return (total/(float)n);
	}
}
