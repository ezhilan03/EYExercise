package inherpack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class InherClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		ShoeFactory factory = new ShoeFactory();
		factory.setName("parent name....");
		
		BataShoeFactory bsf = new BataShoeFactory();
		bsf.setName("Bata parent name");
		bsf.setBataName("bata bata bata");
		
		LakhaniShoeFactory lsf = new LakhaniShoeFactory();
		lsf.setLakhaniName("lakhani lakhani lakhani");
		lsf.setName("lakhani parent name");
		
		session.save(factory);
		session.save(bsf);
		session.save(lsf);
		
		session.beginTransaction().commit();
	}
}
