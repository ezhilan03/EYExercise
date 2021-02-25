package EYExercise.day8;

public class Question11 {
	public static void main(String[] args) {
		new CClass2();
	}
}

class AClass2{
	public AClass2() {
		
	}
	public AClass2(int num) {
		System.out.println("class A instance is created "+num);
	}
}

class BClass2{
	public BClass2(int num) {
		System.out.println("class B instance is created "+num);
	}
}

class CClass2 extends AClass2{
	public CClass2() {
		new AClass2(100);
		new BClass2(90);

	}
}
