package day5;


public class Question59 extends Asteroid{
	public static void main(String argv[]){
		Question59 o = new Question59();
		int iBase=0;
		o.amethod(iBase);
 }
 public void amethod(int iOver){
 System.out.println("Over.amethod");
 }
} 
class Asteroid{
	private void amethod(int iBase){
		System.out.println("Base.amethod");
	}
}