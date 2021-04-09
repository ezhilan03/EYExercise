package annopack;

import java.time.LocalDate;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import utility.HibernateUtility;

public class Client {
	public static void main(String[] args) {
		SessionFactory factory =
				new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEname("ramu");
		emp.setEsal(100);
		emp.setJoiningDate(LocalDate.now());
		
		Address add = new Address();
		
		
		session.save(emp);	
		tx.commit();
		session.close();
	}
}
