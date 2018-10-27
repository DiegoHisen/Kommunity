package Tier3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Tier3Interface extends Remote {
	
	public String login(long cpr, String pwd) throws RemoteException, SQLException;


}
