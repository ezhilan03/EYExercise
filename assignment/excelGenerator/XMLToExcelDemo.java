package InternExercise.assignment.excelGenerator;

import java.lang.reflect.Proxy;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class XMLToExcelDemo {
	public static void main(String[] args) throws Exception{
		Object obj = new XMLToExcelDemo();
		obj = Proxy.newProxyInstance(XMLToExcelDemo.class.getClassLoader(), new Class[] {XMLToExcelConvertable.class}, new MyInvocationHandler(new XMLToExcelConverter()));
		XMLToExcelConvertable converter = (XMLToExcelConvertable)obj;
		converter.writeData("invoice");
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
