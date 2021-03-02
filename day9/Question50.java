package EYExercise.day9;

public class Question50 {
	public static void main(String args[]){ 
		Son son=new Son();  
	    son.eat();  
		son.talk();  
		son.walk();  
	}
}

class Grandfather{  
	void walk() {
		System.out.println("walking...");
	}  
}  
class Father extends Grandfather{  
	void talk() {
		System.out.println("talking...");
	}  
}  
class Son extends Father{  
	void eat(){
		System.out.println("eating...");
	}
}