package controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import model.Citizen;
import model.City;
import model.Message;
import model.Petition;
import model.Post;
import model.UserDetails;

public class Tier3Controller implements ITier3 {

	public Tier3Controller() {

	}

	@Override
	public boolean checkId(String cpr) {
		Session session = databaseFactory1.openSession();
		session.beginTransaction();

		Citizen citizen = session.get(Citizen.class, cpr);

		if (citizen == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public UserDetails createAccount(UserDetails user) {
		if (this.checkId(user.getCpr()) == true) {
			Session session = systemFactory.openSession();
			session.beginTransaction();
			UserDetails databaseUser = user;
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return databaseUser;

		}

		else {
			System.out.println("Id is invalid");
			return null;

		}
	}

	@Override
	public UserDetails checkId_password(UserDetails user) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());

		if (databaseUser.getCpr() == user.getCpr() && databaseUser.GetPassword() == user.GetPassword()) {
			return databaseUser;
		} else {
			System.out.println("Id or password is invalid");
			return null;
		}

	}

	@Override
	public UserDetails changeCity(UserDetails user, String newCity) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());
		City city = new City(0, null);

		city.setName(newCity);
		city.setPostNo(databaseUser.getCity().getPostNo());

		databaseUser.setCity(city);
		return databaseUser;

	}

	public UserDetails changeEmail(UserDetails user, String newEmail) {

		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());

		databaseUser.SetEmail(newEmail);
		return databaseUser;

	}

	@Override
	public UserDetails changePassword(UserDetails user, String oldPass, String newPass) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());

		if (user.GetPassword().equals(oldPass)) {
			user.SetPassword(newPass);
			return databaseUser;
		} else
			return null;

	}

	@Override
	public UserDetails changeRole(UserDetails user, String newRole) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		UserDetails databaseUser = session.get(UserDetails.class, user.getCpr());

		databaseUser.SetRole(newRole);
		return databaseUser;
	}

	@Override
	public Petition approvePetition(Petition response) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Petition databasePetition = session.get(Petition.class, response.getPeid());

		databasePetition.setApproved(true);
		return databasePetition;
	}

	@Override
	public Post officialPost(Post post) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Post databasePost = session.get(Post.class, post.getPid());
		// don t know the purpose of this yet
		return databasePost;
	}

	@Override
	public Post post(Post post) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Post databasePost = session.get(Post.class, post.getPid());
		session.save(post);

		return databasePost;
	}

	@Override
	public Post deletePost(Post post) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Post databasePost = session.get(Post.class, post.getPid());
		if (session.contains(post) == true)
			session.delete(post);
		return databasePost;
	}

	@Override
	public Petition makePetition(Petition petition) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Petition databasePost = session.get(Petition.class, petition.getPeid());
		session.save(petition);
		return databasePost;
	}

	@Override
	public boolean sendMessage(UserDetails sender, UserDetails receiver, Message message) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		message.setSenderid(sender);
		message.setReceiverid(receiver);
		session.save(message);
		return true;
	}

	@Override
	public ArrayList<Post> getPosts(String city) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Post.class).add(Restrictions.eq("city", city));
		ArrayList<Post> list = (ArrayList<Post>) criteria.list();
		return list;

	}
	
	@Override
	public ArrayList<Petition> getApprovedPetitions(boolean value,String city) {
		Session session = systemFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Petition.class)
				.add(Restrictions.eq("approved",value))
				.add(Restrictions.eq("city",city));
		ArrayList<Petition> list = (ArrayList<Petition>) criteria.list();
		return list;

	}

}
