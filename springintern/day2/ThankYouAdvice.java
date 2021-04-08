package day2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class ThankYouAdvice implements AfterReturningAdvice{
	@Override
	public void afterReturning(Object method, Method arg1, Object[] arguments, Object bean) throws Throwable {
		System.out.println("Packing to be done for "+method);
		System.out.println("Thank you and welcome again");
	}
}	
