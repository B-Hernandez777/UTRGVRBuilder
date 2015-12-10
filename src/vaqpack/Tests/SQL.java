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
	final static String Table_user = "`user_table`";// contains email, password, java_objects.
	
	/**
	 * This function requires the email of the user to be passed as a String
	 * in order to work. 
	 * 
	 * @return This returns the vaqPack Object from the DB.
	 */
	public static Object getVaqPack(String email){
		Object vaqPack = null;
		try{
		Connection conn = DriverManager.getConnection(DB, User, Password);
		PreparedStatement getDB = conn
				.prepareStatement("SELECT * from" + Table_user + "WHERE email='" + email + "'");
		ResultSet rs = getDB.executeQuery();
		rs.next();
		vaqPack = rs.getBlob(4);
		rs.close();
		getDB.close();
		System.out.println("SQL getVaqPack() completed");
		}
		catch(SQLException e){
			e.printStackTrace();
			e.getMessage();
		}
		return vaqPack;
	}

	/**
	 * This will update the DB with whatever is in the VaqPack Object to whichever email you specify.
	 * 
	 * @param vaqPack
	 *            This should be the array list object you're passing to
	 *            it.
	 * @param email This is the email of the user that you want to update the object to.
	 * 
	 */
	public void updateDB(Object vaqPack, String email){
		try{
		Connection conn = DriverManager.getConnection(DB, User, Password);
		PreparedStatement updateDB = conn
				.prepareStatement("UPDATE" + Table_user + "SET java_objects=? WHERE email = ?");
		updateDB.setObject(1, vaqPack);
		updateDB.setString(2, email);
		updateDB.executeUpdate();
		updateDB.close();
		conn.close();
		System.out.println("updateDB() completed");
		}
		catch(SQLException e){
			e.printStackTrace();
			e.getMessage();
		}
	}
	/**
	 * Confirms if the email and password match in the DB.
	 * 
	 * Requires the email and password to be strings when passed to this function.
	 * 
	 * @param email
	 * @param password
	 */
	public void confirmLogin(String email, String password){
		try{
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement().executeQuery(
				"SELECT * from   " + Table_user + "  WHERE email = '" + email + "' AND password = '" + password + "'");
		if (!userSearch.next()) {
			System.out.println("ERROR: Email NOT found!");
			// Tell user to register.
		} else {
			// User has successfully logged in,
			// Set the scene to the next screen here.
		}
		userSearch.close();
		conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	/**
	 * Searches for the email that is passed to this function as a String in the DB. 
	 *
	 * @param email This is the email of the user you want to check exists.
	 * @return This returns a boolean, true or false.
	 */
	public boolean userExists(String email){
		Boolean user = null;
		try{
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement().executeQuery(
				"SELECT * from   " + Table_user + "  WHERE email = '" + email + "'");
		if (!userSearch.next()) {
			System.out.println("Email not found!:: from userExists();");
			user = false;
		} else {
			user = true;
		}
		userSearch.close();
		conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			e.getMessage();
		}
		return user;
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
	 * @param vaqPack
	 * 			The object you want to pass to the DB.
	 */
	public void registerUser(String email, String password, Object vaqPack){
		try{
		Connection conn = DriverManager.getConnection(DB, User, Password);
		ResultSet userSearch = conn.createStatement()
				.executeQuery("SELECT * from   " + Table_user + "  WHERE email = '" + email + "' ");

		if (!userSearch.next()) {
			PreparedStatement addDB = conn
					.prepareStatement("INSERT INTO " + Table_user + "(email, password, java_objects) VALUE (?,?,?)");
			addDB.setString(1, email);
			addDB.setString(2, password);
			addDB.setObject(3, vaqPack);
			addDB.executeUpdate();
			addDB.close();
		} else {
			System.out.println("Did not register user, user already exists :: from registerUser()");
			// Tell user to reset password or something.
		}
		userSearch.close();
		conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			e.getMessage();
		}
	}
}
