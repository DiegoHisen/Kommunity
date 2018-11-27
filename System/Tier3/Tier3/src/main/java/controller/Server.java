package controller;

import java.io.IOException;

public class Server 
{
	public static void main(String[] args) throws IOException
	{
		CitizenDatabase database = new CitizenDatabase();
		
		Connection con = new Connection();
		con.registerConnection();
		con.loginConnection();
		
	}

}
