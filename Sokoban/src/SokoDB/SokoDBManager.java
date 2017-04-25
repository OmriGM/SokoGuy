package SokoDB;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class SokoDBManager {
	
	private static SessionFactory factory;
	private static SokoDBManager instance=new SokoDBManager() ;
	
	public static SokoDBManager getInstance() {
		return instance;
	}
	
	private SokoDBManager() {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
		}
	
	private static void searchScoresWhoseNameStartsWith(String prefix) {
		Session session = factory.openSession();
		Query query = session.createQuery("from SokoTable where Username LIKE :prefix");
		query.setParameter("prefix", prefix + "%");
		
		List<Score> list = query.list();
		for (Score e : list) {
			System.out.println(e.getUserName());
		}
		session.close();
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
	// Method to print all Scores
	public static ObservableList<Score> getScoreList(String Levelname,String userName) {
		Session session = factory.openSession();
		ObservableList<Score> list=null;
		Query query;
		
		try {	
			if(Levelname!="" && userName!=""){
				 query = session.createQuery("from SokoDB.Score where (Level =:Levelname and Username=:userName) Order by Steps");
			}
			else
				 query = session.createQuery("from SokoDB.Score where (Level =:Levelname or Username=:userName) Order by Steps");		
			query.setParameter("Levelname",Levelname);		
			query.setParameter("userName",userName);		

			list = FXCollections.observableArrayList(query.list());
			System.out.println(list.getClass());
			for (Score e : list) {
				System.out.println(e.getUserName());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {				
			session.close();			
		}
		return list;
		
	}
	
	
	public void close() {
		factory.close();
	}
}
