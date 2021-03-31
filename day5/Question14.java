package InternExercise.day5;

public class Question14 {
	public static void main(String[] args) {
		int i=0;
		//if(i) {
			//System.out.println("Hello"); //cannot convert from int to boolean
		//}
		boolean b1=true;
		boolean b2=true;
		if(b1==b2)
			System.out.println("true");
		
		int k=1;
		int j=2;
		if(k==1 &| j==2) // there's no such thing as &| operator in java
			System.out.println("OK");
	}
}
