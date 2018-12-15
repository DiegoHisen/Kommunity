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

		//Tier3Controller controller = new Tier3Controller();
		//UserDetails user = new UserDetails("1207883009","da","aa","da","r","ad");
		//controller.createAccount(user);
				
		con.Command();
		
	}

}
