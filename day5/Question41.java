package InternExercise.day5;

public class Question41 {
	static int j = 20;

	public static void main(String argv[]) {
		int i = 10;
		Question41 p = new Question41();
		p.amethod(i);
		System.out.println(i);
		System.out.println(j);
	}

	public void amethod(int x) {
		x = x * 2;
		j = j * 2;
	}
}
