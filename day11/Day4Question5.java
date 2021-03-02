package EYExercise.day11;

public class Day4Question5 {
	public static void main(String[] args) throws MyException{
		int i=10;
		try { // We should have either catch or finally block if we use a try block.
			if(i==10) {
				throw new MyException(); 
			}
		}
		finally{
			System.out.println("hello");
		}
	}
}

