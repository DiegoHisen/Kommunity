package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Citizen;
import model.City;
import model.UserDetails;

public class Tier3Controller implements ITier3
{
	
	public Tier3Controller()
	{
		this.createCitizenDatabase();
	}

	@Override
	public void createCitizenDatabase() 
	{

		Citizen citizen = new Citizen("1207883009");
		Citizen citizen1 = new Citizen("1105823019");
		Citizen citizen2 = new Citizen("1007912211");
		Citizen citizen3 = new Citizen("1505772008");
		Citizen citizen4 = new Citizen("2201413223");
		Citizen citizen5 = new Citizen("1207883009");
		
		
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

	@Override
	public boolean checkId(String cpr) 
	{
		Session session = databaseFactory.openSession();
		session.beginTransaction();
		
		Citizen citizen = session.get(Citizen.class, cpr);
		
		if(citizen==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
		

	@Override
	public void createAccount(String cpr, String password, String name, String email, String role, City city) 
	{
		if (this.checkId(cpr)==true)
		{
			Session session = systemFactory.openSession();
			session.beginTransaction();
			UserDetails user = new UserDetails(cpr,password,name,email,role,city);
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			
		}
		
		else
		{
			System.out.println("Id is invalid");
		}
	}

	@Override
	public boolean checkId_password(String cpr, String password) 
	{
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails user = session.get(UserDetails.class, cpr);
		
		if(user.getCpr()==cpr && user.GetPassword() == password)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

}
