package InternExercise.day1Exercise;
// 23

public class Manipulator {
	public static void main(String[] args) {
		ProtectedData.secretCode+=10;
		System.out.println(ProtectedData.secretCode);
		
	}
}
class ProtectedData{
	protected static int secretCode=1234;
}
