package day2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		
		DBDao DBobj = ctx.getBean("dao",DBDao.class);
		DBobj.test();
	}
}
