package EYExercise.day9;

public class Question47 {

	public static void main(String[] args) {
		Operations obj = new Operations();
		obj.add(10, 20);
		obj.add(10, 20, 30);
		
	}
}

class Operations {
	void add(int num1, int num2) {
		int ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	void add(int num1, int num2, int num3) {
		int ans = num1+num2+num3;
		System.out.println("Addition of "+num1+" & "+num2+" & "+num3+" : "+ans);
	}
}