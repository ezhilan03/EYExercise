package InternExercise.day9;
import java.util.Scanner;
public class Question31 {
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Enter two numbers: ");
	    double first = scan.nextDouble();
	    double second = scan.nextDouble();
	    System.out.print("Enter an operator (+, -, *, /): ");
	    char operator = scan.next().charAt(0);
	    double result;
	    switch (operator) {
	      case '+':
	        result = first + second;
	        break;

	      case '-':
	        result = first - second;
	        break;

	      case '*':
	        result = first * second;
	        break;

	      case '/':
	        result = first / second;
	        break;

	      default:
	        System.out.printf("Error! operator is not correct");
	        return;
	    }

	    System.out.println(first + " " + operator + " " + second + " = " + result);
	  }
}
