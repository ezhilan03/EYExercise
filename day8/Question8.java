package EYExercise.day8;

public class Question8 {
	public static void main(String[] args) {
		Singleton s1 =Singleton.getSingleton();
		Singleton s2 =Singleton.getSingleton();
		s1.str=(s1.str).toUpperCase();
		System.out.println(s1.str);
		System.out.println(s2.str);

	}
}

class Singleton{
	private static Singleton singleton = null;
	public String str="Hello world";
	private Singleton() {}
	public static Singleton getSingleton() {
		if(singleton==null)
			singleton = new Singleton();
		return singleton;
	}
}