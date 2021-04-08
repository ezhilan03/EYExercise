package hyberintern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {
	public static void main(String[] args) {
		
		BookDTO bookobj = new BookDTO(2, "java", "somu", 300,null);
		
		Comment comment = new Comment();
		comment.setMsg("this is a message");
		
		bookobj.setComment(comment);
		
		//Step1 - Load configuration
		Configuration cfg = new Configuration();
		
		//Step2 - Build session factor
		SessionFactory factory = cfg.configure().buildSessionFactory();
		
		//Step3 - Create a session(local cache - clinet specific)
		Session session = factory.openSession();
		
		//create hiberutility class
		
		//to make the DTO hibernate aware, ensure that you call save method of session with the dto.
//		session.save(bookobj);
	
		BookDTO book =(BookDTO) session.get(BookDTO.class, Integer.valueOf(2));	
		System.out.println(book);
		session.beginTransaction().commit();
		
	}
}
