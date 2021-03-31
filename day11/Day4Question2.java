package InternExercise.day11;

public class Day4Question2 {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public static void mth2() {
		try {
			int i=1/0;
		}catch(Exception e) {System.out.println("catch-mth2");}
		finally {
			System.out.println("finally-mth2");
		}
	}
	public static void main(String[] args) {
		Day4Question2 s = new Day4Question2();
		s.mth1();
	}
	
}
