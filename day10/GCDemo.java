package EYExercise.day10;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GCDemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Before thatha's birth "+r.freeMemory());
		Thatha thatha = new Thatha();
		System.out.println("after thatha's birth "+r.freeMemory());
		WeakReference weakTatha=new WeakReference(thatha);
		SoftReference softTatha=new SoftReference(thatha);
		//PhantomReference phantomTatha=new PhantomReference(thatha);
		thatha=null;
		System.out.println("after thatha's death "+r.freeMemory());
		r.gc();
		System.out.println("after kariyam "+r.freeMemory());
		//thatha=(Thatha)softTatha.get();
		//System.out.println(softTatha);
		
	}
}

class Thatha{
	private int money = 10000;
	String space;
	public Thatha() {
		for(int i=0;i<=10000;i++) {
			space=" "+i;
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println(money);
	}
}