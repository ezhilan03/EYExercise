package InternExercise.day1Exercise;
import java.util.Scanner;
public class StudentMarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Students");
		int noOfStudents = sc.nextInt();
		System.out.println("Enter number of Subjects");
		int noOfSubjects = sc.nextInt();
		int [][] marks= new int[noOfStudents][noOfSubjects];
		System.out.println("Enter the marks of each student subject wise");
		for(int i=0;i<noOfStudents;i++) {
			for(int j=0;j<noOfSubjects;j++) {
				marks[i][j] = sc.nextInt();
			}
		}
		for(int i=0;i<noOfStudents;i++) {
			int total=0;
			for(int j=0;j<noOfSubjects;j++) {
				total+=marks[i][j];
			}
			System.out.println("The total marks of Student "+(i+1)+" is "+total);
		}
	}
}
