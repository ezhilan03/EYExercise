package EYExercise.day16;

/*
 *  % - symbol after which  the formatting instruction follows.
 *  [flag]
 *  [width] - in padding how many char we want i.e space.
 *  [.] - precision - this is only for floating points.
 *  s,d,f - to represent string, integer or float.
 */ 
public class StringFormatting {
	public static void main(String[] args) {
		//System.out.printf("formatting instruction", "input");
		System.out.printf("Integer value... %d... %s",100,"Hello world");
		System.out.printf("\n%06d",90); //padding
		System.out.printf("\n%15s %-15s %s","column1","column2","column3"); //padding
		String s = String.format("\n%.3f", 10.12345);
		System.out.println(s);
		met(1,2,3,4,5);
	}
	public static void met(int... i) { //VarArgs 
		for(int ii:i) {
			System.out.println(ii);
		}
	}
}
