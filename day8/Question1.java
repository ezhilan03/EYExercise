package EYExercise.day8;
import java.util.Arrays;
public class Question1 {
	public static void main(String[] args) {
		int num=10;
		int[] arr= {1,2,3};
		Example obj = new Example();	
		System.out.println("the number, array and object before change"+num+Arrays.toString(arr)+obj);
		changeNumber(num);
		changeArray(arr);
		changeObject(obj);
		System.out.println("the number, array and object before change"+num+Arrays.toString(arr)+obj);
		
	}
	static public void changeNumber(int num) {
		num+=10;
	}
	static public void changeArray(int[] arr) {
		arr[0]=1000;
	}
	static public void changeObject(Example obj) {
		obj.change("Goodbye");
	}
}



class Example{
	String s;
	public Example() {
		this.s = "Hello";
	}
	@Override
	public String toString() {
		return "Example [s=" + s + "]";
	}

	public void change(String newString) {
		this.s=newString;
	}
}