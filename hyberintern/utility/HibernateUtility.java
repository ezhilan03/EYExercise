package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private HibernateUtility() {
		// TODO Auto-generated constructor stub
	}
	
	private static SessionFactory factory;
	private static Session session;
	private static Transaction trx;
	static {
		try {
			Configuration cfg = new Configuration();
			factory = cfg.configure().buildSessionFactory();
			
		}catch(Exception e) {e.printStackTrace();}
	}
	
	private static ThreadLocal<Session> tlocal = new ThreadLocal<>();
	
	synchronized public static Session getSession() {
		session =tlocal.get();
		if(session==null) {
			session = factory.openSession();
			trx = session.beginTransaction();
			tlocal.set(session);
		}
		return session;
	}
	synchronized public static Session currentSession() {
		return factory.openSession();
	}
	
	synchronized public static void closeSession(Exception e) {
		session=tlocal.get();
		if(e==null) {
			if(session!=null) {
				trx.commit();
				session.close();
				tlocal.remove();
				
			}
		}
		else {
			if(session!=null) {
				trx.rollback();
				session.close();
				tlocal.remove();
			}
		}
	}
}
