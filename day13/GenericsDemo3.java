package InternExercise.day13;

public class GenericsDemo3 {
	public static void main(String[] args) {
		GenericsDemo3.getElement("Hello");
		GenericsDemo3.getElement(1000);
	}
	
	public static <E>E getElement(E element){
		System.out.println("****"+element+" ****");
		return null;
	}
}
