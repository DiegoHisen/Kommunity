package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import model.UserDetails;

public class Connection
{
	private static Tier3Controller controller;
	private static Socket s;
	private static DataInputStream is;
	private static DataOutputStream os;
	
	public Connection() throws IOException
	{
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Waiting for client request...");
		 Connection.s = ss.accept();
		Connection.is = new DataInputStream(s.getInputStream());
		Connection.os = new DataOutputStream(s.getOutputStream());
	
		
	}
	
	public void Command() throws IOException
	{
		String input = Connection.inputConnection();
		if(input == "findUser")
		{
			this.loginConnection();
		}
		else if(input == "signup")
		{
			this.registerConnection();
		}
		else
		{
			System.out.println("Error");
		}
	}
	
	
	public static String inputConnection() throws IOException
	{

		String fromClient = is.readLine();
		return fromClient;
	}
	
	public static <T> void OutputConnection(T result) throws IOException
	{
		Gson gson = new Gson();

		String json = gson.toJson(result);
		
		os.writeUTF(json);
		
		s.close();
		
		System.out.println("Response sent");
	}
	
	public  void registerConnection() throws IOException
	{
		Gson gson = new Gson();
		
		UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
		
		UserDetails result = controller.createAccount(response);
		
		Connection.OutputConnection(result);
		
	}
	
	
	
	public  void loginConnection() throws IOException
	{

		Gson gson = new Gson();
		
		UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
		
		UserDetails result = controller.checkId_password(response);
		
		Connection.OutputConnection(result);
	}
	
}
