package InternExercise.day8;

public class Question2 {
	public static void main(String[] args) {
		ComplexNumber a = new ComplexNumber(1,2);
		ComplexNumber b = new ComplexNumber(3,4);
		addNumbers(a,b);
		System.out.println(a.real+"+"+a.img+"i");
	}
	public static void addNumbers(ComplexNumber a,ComplexNumber b) {
		a.real = a.real+b.real;
		a.img=a.img+b.img;
	}
}
class ComplexNumber{
	double real,img;
	public ComplexNumber(double real,double img) {
		this.real=real;
		this.img = img;
	}
}