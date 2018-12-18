package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Common.Petition;
import Common.Post;
import Common.User;
import mediator.CitizenDbs;
import mediator.CitizenPersistence;
import mediator.SystemDbs;
import mediator.SystemPersistence;
import smartdocServer.domain.mediator.DBS;
import utility.persistence.MyDatabase;

public class Testing
{
	
	private static CitizenPersistence testCitizen;
	

	@Before
	public static void beforeOpenDatabase() throws ClassNotFoundException
	{
		 testCitizen = new CitizenDbs("jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)","postgres","865feeBA");
		SystemPersistence testSystem = new SystemDbs("jdbc:postgresql://localhost:5432/New_System_Database(SEP3)","postgres","865feeBA");
		testSystem.initializeCitizenDbs("jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)");
	}
	
	
	@Test
	public void checkFakeId()
	{
		User user = new User();
		 user.setCpr("1207883009");
		 assertEquals(testCitizen.CheckId(user),false); 
	}
	
	@Test
//	 
//	// System.out.println(test.CheckId(user));
//	 
	 SystemPersistence testSystem = new SystemDbs("jdbc:postgresql://localhost:5432/New_System_Database(SEP3)","postgres","865feeBA");
	testSystem.initializeCitizenDbs("jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)");
//	 
	//testSystem.createAccount(user);
//	 //testSystem.accesAccount(user);
//	 
//	 Date date =  new Date(0);
//	 
	 Post post = new Post(1,"titlu",user,"s","t","","d");
	 Post pst = new Post(2,"titlu2",user,"s","t","","d");
	 Post pstt = new Post(3,"titlu3",user,"s","t","","c");
//
//	 
	// testSystem.createPost(post);
	 //testSystem.createPost(pst);
//	testSystem.createPost(pstt);

	ArrayList<Post> posts = testSystem.getPostByCity("d");
	for (int i = 0;i<posts.size();i++)
	{
		System.out.println(posts.get(i).getContent());
		
	}
	
	
//	 
	 Petition petition1 = new Petition(1,"panamura",user,"dada","ddd",true);
	 Petition petition2 = new Petition(2,"pattmura",user,"dada","ddd",true);
	 Petition petition3 = new Petition(3,"panamura",user,"dada","ddd",false);
	 Petition petition4 = new Petition(4,"dsada",user,"d2d","ee",false);
	 Petition petition5 = new Petition(4,"dsada",user,"d2d","ee",false);
	 
	 
	 
	Petition petitiontest =  testSystem.createPetition(petition5);
	System.out.println(petitiontest.getContent());
	 //testSystem.createPetition(petition2);
	// testSystem.createPetition(petition4);
	 //Petition newPetition = testSystem.approvePetition(petition4);
	// System.out.println(newPetition.getPeid());
	// testSystem.getApprovedPetition();
	 //testSystem.changeCity(user, "c");
	 //testSystem.changePassword(user,"de");
	 //User newUser =  testSystem.changePassword(user,"ce");
	 //System.out.println(newUser.GetPassword());
//	 
 }

}
