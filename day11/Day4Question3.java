package InternExercise.day11;

public class Day4Question3 {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public static void mth2() {
		try {
			int i=1/0;
		}catch(Exception e) {System.out.println("catch-mth2");}
		finally {
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		Day4Question3 s = new Day4Question3();
		s.mth1();
	}
	
}
