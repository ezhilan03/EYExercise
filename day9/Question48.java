package InternExercise.day9;

public class Question48 {
	public static void main(String[] args) {
		Operations2 obj2 = new Operations2(10, 20);
		Operations2 obj3 = new Operations2(10, 20, 30);
	}
}

class Operations2 {
	public Operations2(int num1, int num2) {
		int ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	public Operations2(int num1, int num2, int num3) {
		int ans = num1+num2+num3;
		System.out.println("Addition of "+num1+" & "+num2+" & "+num3+" : "+ans);
	}
}
