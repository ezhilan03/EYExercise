package manytomany;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import utility.HibernateUtility;

public class CriteriaClient {
	public static void main(String[] args) {
		//CRITERIA API
		Session session = HibernateUtility.getSession();
		
		Criteria crit = session.createCriteria(Student.class);//this is like from Employee
		
		List<Student> students = crit.list();
		Iterator<Student> iter = students.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next().getSname());
		}
	}
}