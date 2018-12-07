package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test 
{
	public static void main(String[] args)
	{
		City city = new City(121212,"cernavoda");
		Citizen citizen = new Citizen("23213");
		UserDetails user = new UserDetails("1","daa","andrei","eada","admin",city);

		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		SessionFactory sessionFactory1 = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Session session1 = sessionFactory1.openSession();
		session.beginTransaction();
		session1.beginTransaction();
		
		session.save(city);
		session.save(user);
		session1.save(citizen);
		session.getTransaction().commit();
		session1.getTransaction().commit();
	}

}
