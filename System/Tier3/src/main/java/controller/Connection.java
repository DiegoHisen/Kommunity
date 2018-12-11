package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import model.Petition;
import model.UserDetails;

public class Connection {
	private static Tier3Controller controller;
	private static Socket s;
	private static DataInputStream is;
	private static DataOutputStream os;

	public Connection() throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Waiting for client request...");
		Connection.s = ss.accept();
		Connection.is = new DataInputStream(s.getInputStream());
		Connection.os = new DataOutputStream(s.getOutputStream());

	}

	public void Command() throws IOException {
		String input = Connection.inputConnection();

		switch (input) {

		case "findUser":
			this.loginConnection();
			break;
		case "signup":
			this.registerConnection();
			break;
		case "changeCity":
			this.changeCity();
			break;
		case "changeEmail":
			this.changeEmail();
			break;
		case "changePassword":
			this.changePassword();
			break;
		case "changeRole":
			this.changeRole();
			break;
		case "approvePetition":
			this.approvePetition();
			break;
		default:
			System.out.println("Error");
			break;

		}

	}

	public static String inputConnection() throws IOException {

		String fromClient = is.readLine();
		return fromClient;
	}

	public static <T> void OutputConnection(T result) throws IOException {
		Gson gson = new Gson();

		String json = gson.toJson(result);

		os.writeUTF(json);

		s.close();

		System.out.println("Response sent");
	}

	public void registerConnection() throws IOException {
		Gson gson = new Gson();

		UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);

		UserDetails result = controller.createAccount(response);

		Connection.OutputConnection(result);

	}

	public void loginConnection() throws IOException {

		Gson gson = new Gson();

		UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);

		UserDetails result = controller.checkId_password(response);

		Connection.OutputConnection(result);
	}

	private void changeCity() throws JsonSyntaxException, IOException {
		Gson gson = new Gson();

		String newCity = inputConnection();

		try {
			UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
			UserDetails result = controller.changeCity(response, newCity);
			boolean success = true;
			Connection.OutputConnection(success);

		} catch (JsonSyntaxException | IOException e) {
			boolean success = false;
			Connection.OutputConnection(success);
		}

	}

	private void changeEmail() throws JsonSyntaxException, IOException {
		Gson gson = new Gson();

		String newEmail = inputConnection();

		try {
			UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
			UserDetails result = controller.changeEmail(response, newEmail);
			boolean success = true;
			Connection.OutputConnection(success);

		} catch (JsonSyntaxException | IOException e) {
			boolean success = false;
			Connection.OutputConnection(success);
		}
	}

	private void changePassword() throws IOException {
		Gson gson = new Gson();

		String oldPass = inputConnection();
		String newPass = inputConnection();

		try {
			UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
			UserDetails result = controller.changePassword(response, oldPass, newPass);
			boolean success = true;
			Connection.OutputConnection(success);
			
		} catch (JsonSyntaxException | IOException e) {
			boolean success = false;
			Connection.OutputConnection(success);
		}

	}
	
	private void changeRole() throws JsonSyntaxException, IOException {
		Gson gson = new Gson();

		String newRole = inputConnection();

		try {
			UserDetails response = gson.fromJson(Connection.inputConnection(), UserDetails.class);
			UserDetails result = controller.changeRole(response, newRole);
			boolean success = true;
			Connection.OutputConnection(success);

		} catch (JsonSyntaxException | IOException e) {
			boolean success = false;
			Connection.OutputConnection(success);
		}

	}
	
	private void approvePetition() throws JsonSyntaxException, IOException {
		Gson gson = new Gson();

		 String state = inputConnection();
         boolean booleanState;
         
         if(state.equals("true")) booleanState=true;
         else booleanState=false;
         
		try {
			Petition response = gson.fromJson(Connection.inputConnection(), Petition.class);
			Petition result = controller.approvePetition(value);
			boolean success = true;
			Connection.OutputConnection(success);

		} catch (JsonSyntaxException | IOException e) {
			boolean success = false;
			Connection.OutputConnection(success);
		}

	}

}
