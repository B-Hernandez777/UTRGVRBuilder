package vaqpack.Tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {
	final static String DB = "jdbc:mysql://localhost:3306/$users";
	final static String User = "student";
	final static String Password = "pass";
	final static String Table_info = "`info_table`";
	final static String Table_user = "`user_table`";// contains email, password, java_objects.
													
	private String user_email = "JohnDoe@hotmail.com";

	/**
	 * This function requires the user_email to already be specified in the
	 * class in order to work. Upon login or registration, the user_email should have been set.
	 * If you're testing, set the user_email in SQL.java on line 18 to whatever it is you're using. 
	 * 
	 * @return This returns the vaqPack Object from the DB.
	 * @throws SQLException
	 */
	public Object getVaqPack() throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		PreparedStatement getDB = conn
				.prepareStatement("SELECT * from" + Table_user + "WHERE email='" + user_email + "'");
		ResultSet rs = getDB.executeQuery();
		rs.next();
		Object vaqPack = rs.getBlob(4);
		rs.close();
		getDB.close();
		System.out.println("SQL getVaqPack() completed");
		return vaqPack;
	}

	/**
	 * This will update the DB with whatever is in the VaqPack Object.
	 * 
	 * @param vaqPack
	 *            This should be the array list object you're passing to
	 *            it.
	 * @throws SQLException
	 */
	public void updateDB(Object vaqPack) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		PreparedStatement updateDB = conn
				.prepareStatement("UPDATE" + Table_user + "SET java_objects=? WHERE email = ?");
		updateDB.setObject(1, vaqPack);
		updateDB.setString(2, this.user_email);
		updateDB.executeUpdate();
		updateDB.close();
		conn.close();
		System.out.println("updateDB() completed");
	}

	/**
	 * Confirms if the email and password match in the DB.
	 * 
	 * Requires 2 strings to be passed to this function.
	 * 
	 * @param email
	 *            The email the user provides as string.
	 * @param password
	 *            The password the user provides as string.
	 * @throws SQLException
	 */
	public void confirmLogin(String email, String password) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement().executeQuery(
				"SELECT * from   " + Table_user + "  WHERE email = '" + email + "' AND password = '" + password + "'");
		if (!userSearch.next()) {
			System.out.println("ERROR: Email NOT found!");
			// Tell user to register.
		} else {
			this.user_email = email;

			// Set the scene to the next screen here.
		}
		userSearch.close();
		conn.close();
	}

	/**
	 * This function adds the email and password strings to the DB, ONLY if the
	 * user does not already exist.
	 * 
	 * Requires 2 strings to be passed to this function.
	 * 
	 * @param email
	 *            The email the user provides as string.
	 * @param password
	 *            The password the user provides as string. 
	 * @throws SQLException
	 */
	public void registerUser(String email, String password) throws SQLException {
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement()
				.executeQuery("SELECT * from   " + Table_user + "  WHERE email = '" + email + "' ");

		if (!userSearch.next()) {
			PreparedStatement addDB = conn
					.prepareStatement("INSERT INTO " + Table_user + "(email, password) VALUE (?,?)");
			addDB.setString(1, email);
			addDB.setString(2, password);
			addDB.executeUpdate();
			addDB.close();
			this.user_email = email;
		} else {
			System.out.println("User already exists.");
			// Tell user to reset password or something.
		}
		userSearch.close();
		conn.close();

	}

}
