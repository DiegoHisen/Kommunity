package Main;

import java.sql.Date;

import Common.Petition;
import Common.Post;
import Common.User;
import mediator.CitizenDbs;
import mediator.CitizenPersistence;
import mediator.SystemDbs;
import mediator.SystemPersistence;

public class Test 
{
 public static void main(String [] args)
 {
	 CitizenPersistence test = new CitizenDbs("jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)","postgres","865feeBA");
	 
	 User user = new User();
	 user.setCpr("1207883009");
	 user.SetPassword("da");
	 user.SetCity("d");
	 User admin = new User();
	 admin.setCpr("1007912211");
	 admin.SetRole("admin");
	// System.out.println(test.CheckId(user));
	 
	 SystemPersistence testSystem = new SystemDbs("jdbc:postgresql://localhost:5432/New_System_Database(SEP3)","postgres","865feeBA");
	 //testSystem.initializeCitizenDbs("jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)");
	 
	//testSystem.createAccount(user);
	 //testSystem.accesAccount(user);
	 
	 //testSystem.createAccount(admin);
	 
	 Date date =  new Date(0);
	 
	 Post post = new Post(1,"titlu",user,"s","t",date,"d");
	 Post pst = new Post(2,"titlu2",user,"s","t",date,"d");
	 Post pstt = new Post(3,"titlu3",user,"s","t",date,"c");

	 
	 //testSystem.createPost(post);
	// testSystem.createPost(pst);
	 //testSystem.createPost(pstt);
	 //testSystem.getPostByCity("d");
	 
	 Petition petition1 = new Petition(1,"panamura",user,date,"ddd",false,user);
	 //testSystem.createPetition(petition1);
	 
	 
 }
}
