package comppack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class CompKeyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		CompKey compkey = new CompKey();
		compkey.setInv_id(1);
		compkey.setItem_id(1);
		
		Invoice inv = new Invoice();
		inv.setCompkey(compkey);
		inv.setDetails("invoice number 1");
		
		session.save(inv);
		
		HibernateUtility.closeSession(null);
	}
}
