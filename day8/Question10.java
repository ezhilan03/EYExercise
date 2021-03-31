package InternExercise.day8;

public class Question10 {
	public static void main(String[] args) {
		new CClass().main(args);;
	}
}

class AClass{
	public AClass() {
		System.out.println("class A instance is created");
	}
}

class BClass{
	public BClass() {
		System.out.println("class B instance is created");
	}
}

class CClass extends AClass{
	public static void main(String[] args) {
		BClass bObj = new BClass();
	}
}