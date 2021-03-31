package InternExercise.day12;

public class LambdaDemo {
	public static void main(String[] args) {
		
		method(new MyInterClass());
		
		method(new MyInter() {
			@Override
			public void met(){
				System.out.println("this is from anonymous inner class");
			}
		});
		
		method(()->{
			System.out.println("This is from Lambda");
		});
		
		int n = method2((s,num)->num+10);
		System.out.println(n);
	}
	
	public static void method(MyInter myInter) {
		myInter.met();
	}
	public static int method2(MyInter2 myInter) {
		return myInter.met2("Hello",10);
	}
}

interface MyInter{
	public void met();
}

interface MyInter2{
	public int met2(String s,int num);
}

class MyInterClass implements MyInter{
	@Override
	public void met() {
		System.out.println("This is from outer class");
	}

}