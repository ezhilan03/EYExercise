package InternExercise.day9;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) throws Exception{
		Police police = new Police();
		Politician politician = new Politician();
		police.arrest(politician);
	}
}

class Police{
	public void arrest(Object accused) throws Exception{
//		accused.service();
//		System.out.println(accused.name);
		
		//introspection
		Class c = accused.getClass();
		Field f = c.getField("name");
		String name = (String)f.get(accused);
		System.out.println("His public name is "+name);
		Method method = c.getMethod("service",new Class[] {int.class});
		System.out.print("His public work is ");
		String value =(String)method.invoke(accused, new Object[] {Integer.valueOf(100)});
		System.out.println(value);
		
		Field fSecret = c.getDeclaredField("secretName");
		fSecret.setAccessible(true);
		String nameSecret = (String)fSecret.get(accused);
		System.out.println("His private name is "+nameSecret);
		Method methodSecret = c.getDeclaredMethod("secretService",new Class[] {int.class});
		methodSecret.setAccessible(true);
		System.out.print("His private work is ");
		value = (String)methodSecret.invoke(accused,new Object[] {Integer.valueOf(100)});
		System.out.println(value);
	}
}

class Politician{
	public String name="Good Man";
	private String secretName="Bad Man";
	public String service(int num) {
		return "social service...";
	}
	private String secretService(int num) {
		return "cheating...";
	}
}

class BogusDoctor{
	
}