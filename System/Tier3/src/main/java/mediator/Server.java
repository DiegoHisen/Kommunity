package mediator;

import java.io.IOException;

public class Server 
{
	public static void main(String[] args) throws IOException
	{
		Citizens database = new Citizens();
		
		Connection con = new Connection();

		con.Command();
		
	}

}
