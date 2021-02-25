package EYExercise.day8;

public class Question6 {
	public static void main(String[] args) {
		new StaticExample();
	}
}
class StaticExample{
	static {
		System.out.println("This is the initialization a static block");
	}
	public StaticExample() {
		System.out.println("this is the initialization of constructor block");
	}
	{
		System.out.println("this is the initialization of instance block");
	}
}