package EYExercise.day11;

public class Day4Question4 {
	public static void main(String[] args) throws MyException{
		int i=10;
		try {
			if(i==10) {
				throw new MyException();}
		}catch(MyException e) {
			System.out.println(e);
		}
		System.out.println("After catching exception");
	}
}
class MyException extends Exception{
	@Override
	public String toString() {
		return "My exception";
	}
}