package InternExercise.day9;

import java.util.Scanner;

public class Question39 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number for which multiplication table should be displayed");
		int num = scan.nextInt();
		Tables obj = new Tables();
		obj.printTables(num);
	}
}

class Tables {
	void printTables(int num) {
		int i=1;
		do {
			System.out.println(num+"*"+i+"="+(num*i));
			i++;
		}while(i<=10);
	}
}