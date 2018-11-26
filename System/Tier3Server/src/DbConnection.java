import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;

import Common.User;

public class DbConnection {

	static Connection con;

	public DbConnection() throws ClassNotFoundException {

		// Initialize connection to database

		Class.forName("org.postgresql.Driver");
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/KommunitySystemDB", "postgres",
					"123123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException, IOException {
		try {

			// Make a server object and start connection to database

			DbConnection server = new DbConnection();

			System.out.println("starting database server...");

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Socket connection with tier2 This method connects with tier2 and EXPECTS the
		 * tier2 only to ask for login It needs to be changed so it only initializes the
		 * connection and reads the service name, then passes the work to the required
		 * service method
		 */
		socketConnection();

	}

	public static void socketConnection() throws SQLException, IOException {

		// create Welcoming socket
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Waiting for client request...");

		// Waiting on the welcoming socket for contact by the client
		Socket s = ss.accept();

		System.out.println("Client connected");

		// Create input and output streams attached to the socket
		DataInputStream is = new DataInputStream(s.getInputStream());
		DataOutputStream os = new DataOutputStream(s.getOutputStream());

		// Read from client

		/*
		 * Here it expects directly to read a user object written in Json with a CPR and
		 * password Should start first with reading a string or integer representing the
		 * required service and then pass to the concerned method (TO BE IMPLEMENTED)
		 */
		String fromClient = is.readLine();

		// Convert from JSON

		Gson gson = new Gson();
		User user = gson.fromJson(fromClient, User.class);

		// Login with received cpr and password
		User result = login(user.cpr, user.password);

		// Convert the result user object to json string
		String json = gson.toJson(result);

		// Send user object in json format
		os.writeUTF(json);

		// Close connection
		s.close();

		System.out.println("Responce sent to client!");

	}

	public static User login(long cpr, String pwd) throws SQLException {

		// Creating an SQL statement to find users with passed CPR and Password
		String sql = "SELECT * FROM users WHERE cpr = " + cpr + " AND password = '" + pwd + "' ;";
		Statement s = con.createStatement();

		// Executing the sql statement and saving the result
		ResultSet result = s.executeQuery(sql);

		// Getting the user attributes from the result if the user exists
		if (result.next()) {
			long UserCPR = result.getLong("cpr");
			String UserName = result.getString("name");
			String UserEmail = result.getString("email");
			String UserRole = result.getString("role");
			String UserCity = result.getString("city");
			String UserPwd = result.getString("password");

			// Creating a user object with the result attributes and returning it
			User user = new User(UserCPR, UserName, UserEmail, UserRole, UserCity, UserPwd);
			return user;

		} else
			return null;

	}

}
