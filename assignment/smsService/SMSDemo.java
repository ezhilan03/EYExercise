package InternExercise.assignment.smsService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SMSDemo {
	public static void main(String[] args) throws Exception{
		Object obj = new SMSDemo();
		obj = Proxy.newProxyInstance(SMSDemo.class.getClassLoader(), new Class[] {SMSSender.class}, new MyInvocationHandler(new SMSService()));
		SMSSender converter = (SMSSender)obj;
		converter.sendSMS("C:\\Users\\ezhil\\OneDrive\\Desktop\\invoice.xml");
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	MyInvocationHandler(Object obj) {
		this.obj=obj;
	}

	@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("invoke method called");
			Object o = method.invoke(obj, args);
			return o;
	}
}