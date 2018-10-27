package Tier1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;




public class Tier1 {
	
	public static void login() throws UnknownHostException, IOException {
		
		Scanner k = new Scanner(System.in);
		
		System.out.println("Enter your CPR: ");
		long cpr = k.nextLong();
		k.nextLine();

		System.out.println("Enter your password: ");
		String pwd = k.nextLine();
		
		
		// Specifying the ip_address and port number for the server machine we want to
		// connect with
		String ip = "localhost";
		int port = 8888;

		// Create a socket to connect with the server
		Socket s = new Socket(ip, port);

		// Create OutputStream attached to the socket
		DataOutputStream os = new DataOutputStream(s.getOutputStream());
		DataInputStream is = new DataInputStream(s.getInputStream());

		// Ask server to login
		    os.writeUTF("Login");
		    is.readUTF();
		// Send credentials    
			os.writeLong(cpr);
			os.writeUTF(pwd);

			System.out.println("Hello " + is.readUTF()); 
		//Close connection
		s.close();
	}
	
	public static void main(String[] args) throws Exception {
		
		
		
		Tier1 t1 = new Tier1();

		System.out.println("Hello you!");
		System.out.println("Enter 1 to login");

		Scanner k = new Scanner(System.in);
		String input = k.nextLine();

		switch (input) {

		case "1":

			login();
			

			break;

		}


	}

}
