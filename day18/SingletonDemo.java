package InternExercise.day18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDemo {
	public static void main(String[] args) throws Exception{
//		ExecutorService es = Executors.newFixedThreadPool(2);
//		es.execute(()->{MyClass.createObject();});
//		es.execute(()->{MyClass.createObject();});
		
		MyClass obj1 = MyClass.getClone();
		MyClass obj2 = MyClass.getClone();
		obj1.s="hello";
		obj2.s="hi";
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1);
		System.out.println(obj2);
	}
}

class MyClass implements Cloneable{
	String s;
	private static MyClass myClass;
	private MyClass() {
		System.out.println("Object is created");
	}
	
	synchronized public static MyClass createObject() {
		if(myClass==null) {
			myClass = new MyClass();
		}
		return myClass;
	}
	
	synchronized public static MyClass getClone() throws Exception{
		if(myClass==null) {
			myClass = new MyClass();
			MyClass myClone = myClass.createClone();
			return myClone;
		}
		else {
			return myClass.createClone();
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyClass [s=" + s + "]";
	}

	public final String getS() {
		return s;
	}

	public final void setS(String s) {
		this.s = s;
	}

	synchronized private MyClass createClone() throws Exception{
		return (MyClass)super.clone();
	}
}