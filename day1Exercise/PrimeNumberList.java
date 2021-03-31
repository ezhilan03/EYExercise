package InternExercise.day1Exercise;
import java.util.ArrayList;
import java.util.List;
public class PrimeNumberList {
	public static void main(String[] args) {
		List<Integer> resultList = new ArrayList<Integer>();
		for(int i=1;i<=100;i++) {
			if(checkPrime(i)) {
				resultList.add(i);
				}
		}
		System.out.println(resultList);
	}
	public static boolean checkPrime(int num) {
		int sqrt = (int) Math.sqrt(num) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (num % i == 0) {return false; }
		} return true;
	}
}
