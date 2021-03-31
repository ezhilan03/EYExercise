package InternExercise.day8;

public class Question5 {
	public static void main(String[] args) {
		new UserDefinedClass();
		new UserDefinedClass();
		new UserDefinedClass();
		new UserDefinedClass();
		new UserDefinedClass();
		new UserDefinedClass().getNoOfObjects();
	}
}
class UserDefinedClass{
	static private int noOfObjects = 0;
	public UserDefinedClass() {
		System.out.println("object is created");
		noOfObjects+=1;
	}
	public void getNoOfObjects() {
		System.out.println("Number of objects is "+noOfObjects);
	}
}
