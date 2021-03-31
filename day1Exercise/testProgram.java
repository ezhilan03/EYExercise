package InternExercise.day1Exercise;
// 17
public class testProgram {
	static final int integerConstant = 20; //Unlike in C language constants are not supported in Java(directly). But, you can still create a constant by declaring a variable static and final.
	public static void main(String[] args) {
		int num=10;
		nonStaticMethod(num);//cannot make static reference to a non static method.
		testProgram obj = new testProgram();
		obj.nonStaticMethod(num); // we can create an instance of the class and access the non static method.
		
		
		OneArgument obj2 = new OneArgument();//the constructor with no argument is not defined.
	}
	public void nonStaticMethod(int num) {
		
	}
}
class OneArgument{
	OneArgument(int num){	}
}
