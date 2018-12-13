package mediator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Citizen;

public class Citizens 
{
	public static final SessionFactory databaseFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
	
	public Citizens()
	{
		Citizen citizen = new Citizen("1207883009");
		Citizen citizen1 = new Citizen("1105823019");
		Citizen citizen2 = new Citizen("1007912211");
		Citizen citizen3 = new Citizen("1505772008");
		Citizen citizen4 = new Citizen("2201413223");
		Citizen citizen5 = new Citizen("2107811009");
		
		
		 Session session = databaseFactory.openSession();
		 session.beginTransaction();
		 session.save(citizen);
		 session.save(citizen1);
		 session.save(citizen2);
		 session.save(citizen3);
		 session.save(citizen4);
		 session.save(citizen5);
		 
		 session.getTransaction().commit();
		 session.close();
		
	}

}
