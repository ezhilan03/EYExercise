package InternExercise.day5;

public class Question30 {
	public static void main(String argv[]) {
	}

	static class MyInner {
	}
}

class Background implements Runnable {
	int i = 0;

	public int run() {
		while (true) {
			i++;
			System.out.println("i=" + i);
		}
		return 1;
	}
}