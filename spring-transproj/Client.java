package sprintrans;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {
	
	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config3.xml");
		
		BusinessBean bb=ctx.getBean("businessadvisedbean",BusinessBean.class);
		
		bb.doTransaction(1,2,100);
		
		System.out.println("Transaction successfull");
	
	}
}
