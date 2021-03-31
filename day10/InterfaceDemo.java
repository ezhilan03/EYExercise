package InternExercise.day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterfaceDemo {
	public static void main(String[] args) {
		/*
		 * Interface is a special class whose activity is promised by the class which implements it, and when an behavioral object is subjected
		 * to the implementation, the behavioral object becomes a component.
		 * 
		 */
		StanelyAlopathyMC stanely = new StanelyAlopathyMC();
		JetAcademy academy = new JetAcademy();
		Human shoaib = new Human();
		//I subject myself to a medical college and at the end I come out as a doctor...
		//implementation and subjection
		
		Object obj = Proxy.newProxyInstance(Human.class.getClassLoader(),
				new Class[] {Doctor.class,Pilot.class}, new MyInvocationHandler(new Object[] {stanely,academy}));
		Doctor doctorShoaib = (Doctor)obj;
		doctorShoaib.doCure();
		
		Pilot pilotShoaib = (Pilot)obj;
		pilotShoaib.doFly();
	}
	
}

class MyInvocationHandler implements InvocationHandler{
	Object[] obj;

	public MyInvocationHandler(Object[] obj) {
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObj=null;
//		System.out.println("Proxy "+proxy);
//		System.out.println("method: "+method.getName());
//		System.out.println("args: "+args);
		
		for(Object o:obj) {
			Method met[] = o.getClass().getDeclaredMethods();
			for(Method m:met) {
				if(m.getName().equals(method.getName())) {
					m.setAccessible(true);
					returnObj = method.invoke(o, args);
				}
			}
		}
		return returnObj;
	}
}

class Human{ //behavioral class
	public void doCry() {
		System.out.println("Crying");
	}
}

interface Doctor{
	public void doCure();
}

class StanelyAlopathyMC implements Doctor{
	@Override
	public void doCure() {
		System.out.println("Cure....");
	}
}

class AUMC implements Doctor{
	@Override
	public void doCure() {
		System.out.println("Do cure....");
	}
}

interface Pilot{
	public void doFly();
}

interface Steward{
	public void doServe();
}

class JetAcademy implements Pilot,Steward{
	@Override
	public void doFly() {
		System.out.println("fly.....");
		
	}
	@Override
	public void doServe() {
		System.out.println("serve.....");
		
	}
}