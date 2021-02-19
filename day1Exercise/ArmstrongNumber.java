package EYExercise.day1Exercise;

public class ArmstrongNumber {
	public static void main(String[] args) {
	    	int num=153;
	    	if(!checkArmstrong(num) && !checkPerfectNumber(num) && !checkPalindrome(num))
	    		System.out.println("It is not Armstrong number or perfect number or palindrome");
	}
	public static boolean checkArmstrong(int num) {
		int sum=0,a,temp;  
	    temp=num;  
	    while(num>0){  
		    a=num%10;  
		    num=num/10;  
		    sum=sum+(a*a*a);  
	    	}  
	    if(temp==sum) {
	    	System.out.println("It is an armstrong number");
	    	return true;
	    	}
	    return false;
	}
	public static boolean checkPerfectNumber(int num) {
		int sum=1;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0 && i*i!=num)
				sum+=i+num/i;
			else if(num%i==0 && i*i==num)
				sum+=i;
		}
		if (sum == num && num != 1) {
	    	System.out.println("It is an Perfect number");
	        return true; }
		return false;
	}
	public static boolean checkPalindrome(int num) {
		int reversedInteger = 0, remainder, originalInteger;
        originalInteger = num;
        while( num != 0 )
        {
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            num  /= 10;
        }
        if (originalInteger == reversedInteger) {
            System.out.println("It is a palindrome.");
            return true;}
        return false;
	}
}
