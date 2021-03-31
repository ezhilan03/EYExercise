package InternExercise.day1Exercise;
//27

public class WorthCalculator {
	public static void main(String[] args) {
		int investment = 14000;
		int valueAfterOneYear=investment+((40/100)*investment);
		int valueAfterTwoYears= valueAfterOneYear-1500;
		int valueAfterThreeYears=valueAfterTwoYears+((12/100)*valueAfterTwoYears);
		System.out.println("$"+valueAfterThreeYears);
	}
}
