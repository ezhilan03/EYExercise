package manytomany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyClient {
	public static void main(String[] args) {
		Session session  = HibernateUtility.getSession();
		
		Student student = new Student();
		student.setSname("ramu");
		student.setMarks(100.0);
		
		Training t1 = new Training();
		t1.setTname("Maths training");
		t1.setTstartdate(LocalDate.now());
		
		Training t2 = new Training();
		t2.setTname("English training");
		t2.setTstartdate(LocalDate.now());
		
		Set<Training> trainings = new HashSet<Training>();
		trainings.add(t1);
		trainings.add(t2);
		
		student.setTrainings(trainings);
		System.out.println(student);
		
		session.save(student);
		HibernateUtility.closeSession(null);
	}
}
