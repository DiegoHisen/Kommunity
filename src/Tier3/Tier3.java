package Tier3;


import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tier3 implements Tier3Interface {

	Connection con;

	public Tier3() throws RemoteException, ClassNotFoundException, SQLException {
		UnicastRemoteObject.exportObject(this, 0);

		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KommunitySystemDB", "postgres", "123123");
	}

	public static void main(String[] args) {
		try {
			// RMIRegistry

			LocateRegistry.createRegistry(1099);
			Tier3 server = new Tier3();
			Naming.rebind("Message", server);

			System.out.println("starting database server...");
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}


	@Override
	public String login(long cpr, String pwd) throws RemoteException, SQLException {

		String sql = "SELECT * FROM users WHERE cpr = "+ cpr +" AND password = '" + pwd + "' ;";
		Statement s = con.createStatement();
		ResultSet result =s.executeQuery(sql);
		
		if(result.next()) {
			String name = result.getString("name");
			String city = result.getString("city");
			String role = result.getString("role");
			
			System.out.println(name+", "+city+", "+role);
			return name;
			
			

		}else return null;
		
	}

}
