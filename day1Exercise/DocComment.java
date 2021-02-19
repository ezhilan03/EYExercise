package EYExercise.day1Exercise;
/**
 * This is a comment
 */
public class DocComment {
	/**When I try to have different names for class and java file it throws java.lang.ClassNotFoundException */
	 public static void main(String[] args) { /** If the public keyword is not mentioned, the main method becomes default no modifier and it is package scope. So when JVM try to access the main method, it cannot find it.
	 * If static keyword is not used, main method becomes instance method. JVM cannot access the main method without creating an instance of it's class.
	 *If parameter is not included, JVM will not recognize the main() method as JVM always looks for the main() method with a string type array as a parameter.
	  */
		System.out.println("This is the main method");
	}

}
