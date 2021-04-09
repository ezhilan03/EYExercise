package annopack.onetomanypack;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client1 {
	public static void main(String[] args)throws Exception {
		//SessionFactory fac=new Configuration().configure().buildSessionFactory();
		
		SessionFactory factory = 
			new Configuration().
			configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEid(100);
		emp.setEname("ramu");
		emp.setEsalary(1000);
		
		Address add1=new Address();
		add1.setAid(200);
		add1.setStreet("raja raja street");
		add1.setEmployee(emp);
		
		Address add2=new Address();
		add2.setAid(300);
		add2.setStreet("rani rani street");
		add2.setEmployee(emp);
		
		Set set=new HashSet();
		set.add(add1);
		set.add(add2);
		
		emp.setAddresses(set);
		
		session.save(add1);
		session.save(add2);
		session.save(emp);
		
		tx.commit();
		
//		 emp=(Employee)session.get(Employee.class,Integer.valueOf(100));
//		Collection col=emp.getAddresses();
//		Iterator iter=col.iterator();
//		while(iter.hasNext())
//		{
//			Address add=(Address)iter.next();
//			System.out.println(add.getStreet());
//		}
		
		
		
	}
}
