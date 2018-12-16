package mediator;

import java.io.IOException;

import controller.Tier3Controller;
import model.City;
import model.UserDetails;

public class Server 
{
	public static void main(String[] args) throws IOException
	{
		
		
	    Connection con = new Connection();

	
		Tier3Controller controller = new Tier3Controller();
		UserDetails user = new UserDetails("1207883009","da","aa","da","NU","ad");
		UserDetails databaseuser = controller.createAccount(user);
//		System.out.println(databaseuser.getCpr());
//		UserDetails loginuser =  controller.checkId_password(databaseuser);
//		System.out.println(loginuser.getCpr());
//		
		
				
					con.Command();
			
		
		
	}

}
