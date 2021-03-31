package InternExercise.day9;

public class Question36 {
	public static void main(String[] args) {
		Palindrome obj = new Palindrome();
		if(obj.checkNumberPalindrome(125))
			System.out.println("Palindrome Number");
		else
			System.out.println("Not a palindrome number");
		
		
		if(obj.checkStringPalindrome("liril")) 
			System.out.println("Palindrome string");
		else
			System.out.println("Not a palindrome string");
	}
}

class Palindrome {
	
	boolean checkNumberPalindrome(int num) {
		int temp = num;
		int dig;
		int rev=0;
		
		while(num > 0) {
			dig = num%10;
			rev = (rev*10)+dig;
			num=num/10;
		}
		
		if(temp == rev) 
			return true;
		
		return false;
	}
	
	boolean checkStringPalindrome(String str) {
		int first=0;
		int last = str.length()-1;
		char ch[] = str.toCharArray();
		
		while(first < last) {
			if(ch[first] != ch[last])
				return false;
			first++;
			last--;
		} 
		return true;
	}
}