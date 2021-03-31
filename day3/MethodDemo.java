package InternExercise.day3;

public class MethodDemo {
	int i = 1;
	float f = 2.2f;
	long l = 3l;
	double d = 4.4;
	char c = '5';
	String s = "this is a string";
	boolean b = true;

	public static void main(String[] args) {
		MethodDemo demo = new MethodDemo();
		met(5);
		System.out.println(met2("abc"));
		// System.out.println(a);
	}

	public void met(int i) {
		System.out.println(i);
	}

	public static void met(int... i) {
		for (int x : i) {
			System.out.println(x);
		}
	}

	public static int met2(int i) {
		return i;
	}

	public static String met2(String s) {
		return s + "Hello";
	}
}
