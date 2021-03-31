package InternExercise.day9;
import java.util.Scanner;

public class Question24 {
	public static void main(String[] args) {
		Scanner scan  =  new Scanner(System.in);
		System.out.println("Enter the length of the side of the Square");
		int size = scan.nextInt();
		System.out.println("Enter the length and breadth of Rectangle");
		int length = scan.nextInt();
		int breadth = scan.nextInt();
		scan.close();
		System.out.println("Area of Square is "+findAreaSquare(size));
		System.out.println("Area of Rectangle is "+findAreaRectangle(length, breadth));
	}
	public static int findAreaSquare(int size) {
		return size*size;
	}
	public static int findAreaRectangle(int length,int breadth) {
		return length*breadth;
	}
}
