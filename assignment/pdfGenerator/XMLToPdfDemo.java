package InternExercise.assignment.pdfGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XMLToPdfDemo {
	public static void main(String[] args) throws Exception{
		Object obj = new XMLToPdfDemo();
		obj = Proxy.newProxyInstance(XMLToPdfDemo.class.getClassLoader(), new Class[] {XMLToPdfConvertable.class}, new MyInvocationHandler(new XMLToPdfConveter()));
		XMLToPdfConvertable converter = (XMLToPdfConvertable)obj;
		converter.convert("invoice");
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