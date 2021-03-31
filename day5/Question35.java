package InternExercise.day5;

public class Question35 {
	public static void main(String argv[]) {
		Question35 c = new Question35();
		String s = new String("ello");
		c.amethod(s);
	}

	public void amethod(String s) {
		char c = 'H';
		c += s;
		System.out.println(c);
	}
}
