package day5;


class Base {}  
class Sub extends Upper {}  
class Sub2 extends Upper {} 
public class Question17{        
	public static void main(String argv[]){
		Upper b=new Upper();                 
		Sub s=(Sub) b;                 }
}// run time error as class cast exception