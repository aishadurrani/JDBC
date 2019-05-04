package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {
	static Connection conn = null;
	ResultSet rs = null;
	static String url = "jdbc:mysql://localhost:3306/students";
	static String user = "root";
	static String pass = "password";

	static void establishConnection() {
		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllUsers() {
		try {
			while (rs.next()) {
				String email = rs.getString(1);
				String name = rs.getString(2);

				System.out.println("Email: " + email + ", name: " + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getUsersByName(String name) throws SQLException {
		Statement stmt = conn.createStatement();
		String sql = "SELECT email, name FROM Users WHERE name = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		rs = ps.executeQuery();
		while (rs.next()) {
			String email = rs.getString(1);
			String nm = rs.getString(2);

			System.out.println("Email: " + email + ", name: " + nm);
		}
	}

	public boolean validateUser(String email, String password) throws SQLException {
		String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);

		rs = ps.executeQuery();
		return rs.first();
	}

	public void updateUser(String email, String name, String password) throws SQLException {
		String sql = "UPDATE Users set name = ?, password = ? where email = ? ";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, name);
		prepStmt.setString(2, password);
		prepStmt.setString(3, email);
		if (prepStmt.executeUpdate() == 1) {
			System.out.println("User was updated successfully");
		} else {
			System.out.println("User was not updated successfully");
		}
	}

	public static void main(String[] args) {
		try {
			UserTable us = new UserTable();
			establishConnection();
			String sql = "";
			Statement stmt = conn.createStatement();
//			sql = "Create Table Users (Email VARCHAR(100), name VARCHAR(50), password VARCHAR(30))";
//			stmt.executeUpdate(sql);
//			System.out.println("table created successfully...");
//			sql = "INSERT INTO Users (email, name, password) values" + "('ywbaek@perscholas.org', 'young', 'platform'),"
//					+ "('mcordon@perscholas.org', 'marcial', 'platform'),"
//					+ "('mhaseeb@perscholas.org', 'haseeb', 'platform')";
//			stmt.executeUpdate(sql);
			sql = "SELECT * FROM Users";
			us.rs = stmt.executeQuery(sql);
			us.getAllUsers();
			System.out.println();
			us.getUsersByName("young");
			System.out.println(us.validateUser("ywbaek@perscholas.org", "platform"));
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
