package day2;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		System.out.println("after init...."+bean+" = "+name);
		try {
			Field field = bean.getClass().getSuperclass().getDeclaredField("key");
			if(field!=null) {
				field.setAccessible(true);
				String keyValue = (String)field.get(bean);
				if(keyValue==null) {
					keyValue="key set by bean processor";
					field.set(bean, keyValue);
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		System.out.println("before init...."+bean+" = "+name);
		return bean;
	}
	
}
