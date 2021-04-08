package day2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FactoryClient {
	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
			//new FileSystemXmlApplicationContext();
			
			ShoeSeller seller=ctx.getBean("advicedShop",ShoeSeller.class);
			
			Customer customer=new ShoeCustomer("ramu");
			
			Export exporter = (Export)seller;
			exporter.doExport();
			
			seller.test();
	//		System.out.println(seller.getFactory().getKey());
	//		System.out.println(seller.getKey());
			
	//		ctx.getBean("shop",ShoeSeller.class);
	//		ctx.getBean("shop",ShoeSeller.class);
			
	//		GokulShoeShop seller2=seller.getClone();
	//		
	//		System.out.println(seller2.getName());
	//		System.out.println(seller2.getMylist());
			ctx.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
