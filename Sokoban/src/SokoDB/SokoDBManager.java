package SokoDB;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class SokoDBManager {
	private static SokoDBManager instance = new SokoDBManager();
	
	public static SokoDBManager getInstance() {
		return instance;
	}
	private SessionFactory factory;
	
	private SokoDBManager() {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}
	
	public void addScore(Score score){
		Session session = null;
		Transaction tx = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
						
			session.save(score);
			tx.commit();			
		}
		catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		}
		finally {
			if (session != null)
				session.close();
		}		
		
	}
	
	
	public void close() {
		factory.close();
	}
}
