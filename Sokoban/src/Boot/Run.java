package Boot;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import SokoDB.Score;


public class Run {
	private static SessionFactory factory;

	public static void main(String[] args) {
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
		
		// Add a few Score records in the database
		int add = addScore("yoavvv",  "level 1",  36,  78);

		System.out.println("Scores list:");
		printScores();
		//printScoresWhoseNameStartsWith("Omri");
		factory.close();

	}

	private static int addScore(String userName, String levelName, int steps, int time) {
		Score score = new Score(userName,  levelName,  steps,  time);
		Transaction tx = null;
		int ID = 0;
		Session session = factory.openSession();
		try {
			tx = session.beginTransaction();
			ID = (Integer) session.save(score);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		
		}
		return ID;
	}

	// Method to print all Scores
	private static void printScores() {
		Session session = factory.openSession();
		try {
			Query<Score> query = session.createQuery("from SokoTable");
			List<Score> list = query.list();
			for (Score e : list) {
				System.out.println(e.getTime());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			
		}
	}
	// Method to print all Scores whose names start with specified prefix

	private static void printScoresWhoseNameStartsWith(String prefix) {
		Session session = factory.openSession();
		Query query = session.createQuery("from SokoTable where Username LIKE :prefix");
		query.setParameter("prefix", prefix + "%");
		List<Score> list = query.list();
		for (Score e : list) {
			System.out.println(e.getLevelName());
		}
		session.close();
	}

	// Method to update a salary for an Score
//	private static void updateSalary(int empId, double salary) {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			Score emp = session.get(Score.class, empId);
//			//emp.setSalary(salary);
//			session.update(emp);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null)
//				tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//	}

	// Method to delete an Score
	private static void deleteScore(int empId) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Score emp = session.get(Score.class, empId);
			session.delete(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
		}
		
	}
	
}
