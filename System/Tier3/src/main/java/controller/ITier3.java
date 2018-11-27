package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.City;

public interface ITier3 
{
	public void createCitizenDatabase();
	public boolean checkId(String cpr);
	public void createAccount(String cpr,String password,String name,String email,String role,City city);
	public boolean checkId_password(String cpr,String password);
	
	public static final SessionFactory databaseFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
	public static final SessionFactory systemFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

}
