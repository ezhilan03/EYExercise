package InternExercise.day11;
import java.util.Scanner;

public class Day4Question8 {
	public static void main(String[] args) {
		double[] arr=new double[10];
		boolean flag=true;
		double sum=0;
		Scanner scan = new Scanner(System.in);
		while(flag) {
			System.out.println("Enter the marks for 10 students");
			try {
				for(int i=0;i<10;i++) {
					int temp=Integer.parseInt(scan.next());
					if(temp<0)
						throw new NegativeException();
					else if(temp>100)
						throw new OutOfRangeException();
					arr[i] = (double)temp;
					sum+=arr[i];
				}
				System.out.println("Average is "+(sum/10));
				break;
			}catch(NumberFormatException nme) {
				System.out.println(nme);
			}catch(NegativeException ne) {
				System.out.println(ne);
			}catch(OutOfRangeException oore) {
				System.out.println(oore);
			}
		}
	}
}

class NegativeException extends Exception{
	@Override
	public String toString() {
		return "Please enter positive number";
	}
}

class OutOfRangeException extends Exception{
	@Override
	public String toString() {
		return "Enter number between 0 and 100";
	}
}
