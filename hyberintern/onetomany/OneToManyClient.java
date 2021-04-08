package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class OneToManyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Employee emp = new Employee();
		emp.setEname("somu");
		emp.setEsal(2000);
		
		Address add1 = new Address();
		add1.setCity("dubai");
		add1.setStreet("kurukku sandhu");
		add1.setEmp(emp);
		
		Address add2 = new Address();
		add2.setCity("US");
		add2.setStreet("ulavar sandhai");
		add2.setEmp(emp);
		
		Set<Address> set = new HashSet<Address>();
		set.add(add1);
		set.add(add2);
		
		emp.setAddresses(set);
		
		session.save(emp);
//		session.save(add1);
//		session.save(add2);
		
		HibernateUtility.closeSession(null);
	}
}
