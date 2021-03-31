package InternExercise.day9;
import java.util.Scanner;  

public class Question32 {  
   public static void main(String[] args) {  
       Scanner scan = new Scanner(System.in);  
       System.out.print("Enter a number : ");  
       int num = scan.nextInt();  
       if (isPrime(num)) {  
           System.out.println(num + " is a prime number");  
       } else {  
           System.out.println(num + " is not a prime number");  
       }  
   }  
  
   public static boolean isPrime(int num) {  
       if (num <= 1) {  
           return false;  
       }  
       for (int i = 2; i < Math.sqrt(num); i++) {  
           if (num % i == 0) {  
               return false;  
           }  
       }  
       return true;  
   }  
}  