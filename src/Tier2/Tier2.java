package Tier2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Scanner;

import Tier3.Tier3Interface;;

public class Tier2 {
	

	private static Tier3Interface dBserver;

	public Tier2() throws NotBoundException, IOException {
		dBserver = (Tier3Interface) Naming.lookup("rmi://localhost:1099/Message");
		
		
	}

	public static String login(long cpr, String pwd) throws SQLException, IOException, NotBoundException {
		Tier2 t2 = new Tier2();

		
		return dBserver.login(cpr, pwd);

	}

	public static void main(String[] args) throws NotBoundException, SQLException, IOException {

		 
		System.out.println("Welcome to the Server");

        socketConnection();
		


	}
	
	public static void socketConnection() throws IOException, SQLException, NotBoundException {
		// create Welcoming socket
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Waiting for client request...");

		// Waiting on the welcoming socket for contact by the client
		Socket s = ss.accept();

		System.out.println("Client connected");

		// Create input and output stream attached to the socket
		DataInputStream is = new DataInputStream(s.getInputStream());
		DataOutputStream os = new DataOutputStream(s.getOutputStream());

		// Read from client
		String service = is.readUTF();
		
		if(service.equals("Login")) {
			os.writeUTF("Send your credentials");
			long cpr = is.readLong();
			String pwd = is.readUTF();
			
			os.writeUTF(login(cpr, pwd));
		}
		
		
	}

}
