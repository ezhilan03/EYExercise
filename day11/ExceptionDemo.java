package InternExercise.day11;

public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("Before error");
		try {
			int i=1/0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("this is finally block");
		}
		System.out.println("after error");
	}
}
