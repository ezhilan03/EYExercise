package InternExercise.day5;

public class Question11 {

}

abstract class MineBase {
	abstract void amethod();

	static int i;
}

public class Mine extends MineBase { // If a class extends an abstract class it should implement the abstract methods
										// or it should also be an abstract class
	public static void main(String[] args) {
		int[] ar = new int[5];
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
}