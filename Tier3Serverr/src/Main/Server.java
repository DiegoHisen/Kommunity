package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import Common.Petition;
import Common.Post;
import Common.User;
import mediator.SystemDbs;
import mediator.SystemPersistence;


public class Server
{
	private static ServerSocket ss;
	private static Socket s ;
	private static DataInputStream is ;
	private static DataOutputStream os ;
	
	
	private static final String urlCitizen = "jdbc:postgresql://localhost:5432/New_Citizen_Database(SEP3)";
	private static final String urlSystem = "jdbc:postgresql://localhost:5432/New_System_Database(SEP3)";
	private static final String username = "postgres";
	private static final String password = "865feeBA";
	
	private static final SystemPersistence systemDbs = new SystemDbs(urlSystem,username,password);
	

public static void main(String[] args) throws IOException {
		
		ss = new ServerSocket(8888);
		System.out.println("Waiting for client request...");
		
		socketConnection();
		
	}

public static void Command(String input) throws IOException {

	switch (input) {

	case "findUser":
		login();
		break;
	case "signup":
		register();
		break;
//	/*case "changeCity":
//		this.changeCity();
//		break;*/
//	case "changeEmail":
//		this.changeEmail();
//		break;
//	case "changePassword":
//		this.changePassword();
//		break;
//	case "changeRole":
//		this.changeRole();
//		break;
//	case "approvePetition":
//		this.approvePetition();
//		break;
//	case "officialPost":
//		this.officialPost();
//		break;
	case "Post":
		Server.Post();
		break;
//	case "deletePost":
//		this.deletePost();
//		break;
	case "makePetition":
		Server.makePetition();
		break;
//	case "sendMessage":
//		this.sendMessage();
//		break;
	case "getPosts":
		getPosts();
		break;
//	case "getApprovedPetitions":
//		this.getApprovedPetitions();
//		break;
//	case "getUnapprovedPetitions":
//		this.getUnapprovedPetitions();
//		break;
		
	default:
		System.out.println("Unrecognized command received!");
		break;

	}

}
	
	public static void socketConnection() throws IOException {

		while( true) {
			// Waiting on the welcoming socket for contact by the client
			s = ss.accept();
			System.out.println("Client connected");

			is = new DataInputStream(s.getInputStream());
			os = new DataOutputStream(s.getOutputStream());

			// Read from client

				String fromClient = is.readLine();
				System.out.println("This command is from client: "+fromClient);
				
				Command(fromClient);
			
		}

	}
	
	
	
	public static void login() throws IOException
	{
		
		String fromClient = is.readLine();
		System.out.println("This user is from client: "+fromClient);
		Gson gson = new Gson();
		User userFromClient = gson.fromJson(fromClient, User.class);
		System.out.println("Converted from json: "+userFromClient);
		
		User databaseuser = systemDbs.accesAccount(userFromClient);
			
			
		String json = gson.toJson(databaseuser);
		System.out.println("Found in database: "+databaseuser.getCpr() + " ...with pwd: "+ databaseuser.GetPassword());
		System.out.println("Sending to client: "+json);
		os.writeUTF(json);
		s.close();
		System.out.println("Response sent to client!");
						
			
		}
	
	
	
	public static void register() throws IOException
	{
		String fromClient = is.readLine();
		System.out.println("This user is from client: "+fromClient);
		Gson gson = new Gson();
		User userFromClient = gson.fromJson(fromClient, User.class);
		System.out.println("Converted from json: "+userFromClient);
		
		System.out.println(userFromClient.getCpr());
		systemDbs.initializeCitizenDbs(urlCitizen);
		User databaseuser = systemDbs.createAccount(userFromClient);		
		String json = gson.toJson(databaseuser);
		System.out.println("Found in database: "+databaseuser.getCpr() + " ...with pwd: "+ databaseuser.GetPassword());
		System.out.println("Sending to client: "+json);
		// Send user object in json format
		os.writeUTF(json);
		s.close();
		System.out.println("Response sent to client!");
						
			
			

	}
	
	
	public static void Post() throws IOException
	{
		String fromClient = is.readLine();
		System.out.println("This post is from client: "+fromClient);
		Gson gson = new Gson();
		Post postFromClient = gson.fromJson(fromClient, Post.class);
		System.out.println("Converted from json: "+postFromClient);
		
		System.out.println(postFromClient.getPid());
		
		Post databasepost = systemDbs.createPost(postFromClient);		
		String json = gson.toJson(databasepost);
		System.out.println("Found in database: "+databasepost.getPid() + " ...with title: "+ databasepost.getTitle());
		System.out.println("Sending to client: "+json);
		// Send user object in json format
		os.writeUTF(json);
		s.close();
		System.out.println("Response sent to client!");
	}


	public static void getPosts() throws IOException
	{

		String fromClient = is.readLine();
		System.out.println("This city is from client: "+fromClient);
		Gson gson = new Gson();
		String cityFromClient = gson.fromJson(fromClient, String.class);
		System.out.println("Converted from json: "+cityFromClient);
		
		System.out.println(cityFromClient);
		
		ArrayList<Post> databaseposts = systemDbs.getPostByCity(cityFromClient);		
		String json = gson.toJson(databaseposts);
		System.out.println("Sending to client: "+json);
		// Send user object in json format
		os.writeUTF(json);
		s.close();
		System.out.println("Response sent to client!");
	}
	
	
	public static void makePetition() throws IOException
	{
		String fromClient = is.readLine();
		System.out.println("This petition is from client: "+fromClient);
		Gson gson = new Gson();
		Petition petitionFromClient = gson.fromJson(fromClient, Petition.class);
		System.out.println("Converted from json: "+petitionFromClient);
		
		System.out.println(petitionFromClient.getPeid());
		
		Petition databasepetition = systemDbs.createPetition(petitionFromClient);		
		String json = gson.toJson(databasepetition);
		System.out.println("Found in database: "+databasepetition.getPeid() + " ...with title: "+ databasepetition.getTitle());
		System.out.println("Sending to client: "+json);
		// Send user object in json format
		os.writeUTF(json);
		s.close();
		System.out.println("Response sent to client!");

	}
	
}
