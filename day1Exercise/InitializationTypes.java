package EYExercise.day1Exercise;

public class InitializationTypes {
	static int variableStatic = 10;
	int variableInstance = 20;
	//explicit type casting
	byte variableStatic2 = (byte) variableStatic;
	byte variableInstance2 = (byte) variableInstance;
	
	//implicit type casting
	long variableStatic3 = (long) variableStatic;
	long variableInstance3 = (long) variableInstance;
	public static void main(String[] args) {
		int variableLocal = 30;
		byte variableLocal2 = (byte) variableLocal; //explicit
		long variableLocal3 = (long) variableLocal; //implicit
	}
}
