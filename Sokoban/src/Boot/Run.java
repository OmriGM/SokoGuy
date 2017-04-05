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
		int empID1 = addScore("Omri",  "Grossman",  36,  78);
//		int empID2 = addScore("Daisy", "Das", 5000);
//		int empID3 = addScore("John", "Paul", 10000);
//		int empID4 = addScore("Jane", "Paul", 8000);
		System.out.println("Scores list:");
		printScores();
		System.out.println("Scores whose name start with J:");
		printScoresWhoseNameStartsWith("J");
		System.out.println("Updating salary for Score 1");
		//updateSalary(empID1, 2333.33);
		System.out.println("Deleting Score 3");
		System.out.println("Scores list:");
		printScores();
	}

	private static int addScore(String userName, String levelName, int steps, int time) {
		Score emp = new Score(userName,  levelName,  steps,  time);
		Transaction tx = null;
		int empID = 0;
		Session session = factory.openSession();
		try {
			tx = session.beginTransaction();
			empID = (Integer) session.save(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return empID;
	}

	// Method to print all Scores
	private static void printScores() {
		Session session = factory.openSession();
		try {
			Query<Score> query = session.createQuery("from Scores");
			List<Score> list = query.list();
			for (Score e : list) {
				System.out.println(e);
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
		Query query = session.createQuery("from Scores E where E.first_name LIKE :prefix");
		query.setParameter("prefix", prefix + "%");
		List<Score> list = query.list();
		for (Score e : list) {
			System.out.println(e);
		}
		session.close();
	}

	// Method to update a salary for an Score
	private static void updateSalary(int empId, double salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Score emp = session.get(Score.class, empId);
			//emp.setSalary(salary);
			session.update(emp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

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
