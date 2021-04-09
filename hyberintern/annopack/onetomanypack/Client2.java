package annopack.onetomanypack;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Client2 {
	public static void main(String[] args)throws Exception {
		//SessionFactory fac=new Configuration().configure().buildSessionFactory();
		
		SessionFactory factory = 
			new AnnotationConfiguration().
			configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee emp=new Employee();
		emp.setEid(200);
		emp.setEname("somu");
		emp.setEsalary(1000);
		
		
		Set<Employee> sett=new HashSet<Employee>();
		sett.add(emp);
		
		Training t1=new Training();
		t1.tid=1000;
		t1.tname="java";
//		t1.setEmployee(sett);
		
		Training t2=new Training();
		t2.tid=2000;
		t2.tname="jpa";
//		t2.setEmployee(sett);
		
		Set<Training> settt=new HashSet();
		settt.add(t1);settt.add(t2);		
		emp.setTrainings(settt);
		
		session.saveOrUpdate(emp);
		session.save(t1);
		session.save(t2);
		
		tx.commit();
		
//		 emp=(Employee)session.get(Employee.class,new Integer(100));
//		Collection col=emp.getTrainings();
//		Iterator iter=col.iterator();
//		while(iter.hasNext())
//		{
//			Training add=(Training)iter.next();
//			System.out.println(add.getTname());
//		}
	}
}
