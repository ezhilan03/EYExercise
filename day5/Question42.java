package InternExercise.day5;

public class Question42 {
	public static void main(String argv[]) {
		Question42 l = new Question42();
		l.amethod();
	}

	public void amethod() {
		int ia[] = new int[4];
		for (int i = 0; i < 4; i++) {
			ia[i] = i;
			System.out.println(ia[i]);
		}
	}
}