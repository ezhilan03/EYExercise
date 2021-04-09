package annopack.minherpack;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Client {
	public static void main(String[] args) {
		SessionFactory factory = 
				new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			
			Session session=factory.openSession();
			Transaction tx=session.beginTransaction();

			Maruti maruti=new Maruti();
			maruti.setAutofeature("auto features...");
			maruti.setCarfeatures("car features....");
			maruti.setMarutifeatures("maruti features....");
			
			session.save(maruti);
			
			Car car=new Car();
			car.setAutofeature("aaaaaaaaaaaaaaaaaaaa");
			car.setCarfeatures("ccccccccccccccccccccc");
			
			session.save(car);
			tx.commit();
			
			Query q=session.createQuery("select a from auto a");
			List l=q.list();
			Iterator i=l.iterator();
			while(i.hasNext())
			{
				Automobile a=(Automobile)i.next();
				a.handle();
			}	
	}
}
