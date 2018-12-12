package controller;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.City;
import model.Message;
import model.Petition;
import model.Post;
import model.UserDetails;

public interface ITier3 {

	public boolean checkId(String cpr);

	public UserDetails createAccount(UserDetails user);

	public UserDetails checkId_password(UserDetails user);

	public UserDetails changeCity(UserDetails user, String newCity);

	public UserDetails changePassword(UserDetails user, String oldPass, String newPass);

	public UserDetails changeRole(UserDetails user, String newRole);

	public Petition approvePetition(Petition response);

	public Post officialPost(Post post);

	public Post post(Post post);

	public Post deletePost(Post post);

	public Petition makePetition(Petition petition);

	public boolean sendMessage(UserDetails sender, UserDetails receiver, Message message);

	public ArrayList<Post> getPosts(String city);

	public ArrayList<Petition> getApprovedPetitions(boolean value,String city);

	public static final SessionFactory databaseFactory1 = new Configuration().configure("hibernate.cfg1.xml")
			.buildSessionFactory();
	public static final SessionFactory systemFactory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

}
