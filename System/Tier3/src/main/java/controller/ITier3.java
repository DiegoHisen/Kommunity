package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.City;
import model.UserDetails;

public interface ITier3 {
	public boolean checkId(String cpr);

	public UserDetails createAccount(UserDetails user);

	public UserDetails checkId_password(UserDetails user);
	
	public UserDetails changeCity(UserDetails user,String newCity);
	
	public UserDetails changePassword(UserDetails user,String oldPass,String newPass);

	public static final SessionFactory databaseFactory = new Configuration().configure("hibernate.cfg1.xml")
			.buildSessionFactory();
	public static final SessionFactory systemFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

}
