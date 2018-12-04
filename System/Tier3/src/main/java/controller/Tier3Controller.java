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
	public UserDetails createAccount(UserDetails user) 
	{
		if (this.checkId(user.getCpr())==true)
		{
			Session session = systemFactory.openSession();
			session.beginTransaction();
			UserDetails databaseUser = user;
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return databaseUser;
			
			
		}
		
		else
		{
			System.out.println("Id is invalid");
			return null;
			
		}
	}

	@Override
	public UserDetails checkId_password(UserDetails user) 
	{
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());
		
		if(databaseUser.getCpr()==user.getCpr() && databaseUser.GetPassword() == user.GetPassword())
		{
			return databaseUser;
		}
		else
		{
			System.out.println("Id or password is invalid");
			return null;
		}
		
	}
	

}
