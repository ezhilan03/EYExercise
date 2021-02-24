package day5;

public class Question16 {
		protected void met() {
		
	}
}
class Child extends Question16{
	@Override
	private void met() { // cannot reduce the visibility of inherited class
	}
	
	private static void met2() {
		
	}
	private static void met2(int i) throws Exception{ // we can overload the static methods
		//private methods can be overloaded.
		//overloaded methods can throw exception which is not mentioned in the base class
	}
	
}
