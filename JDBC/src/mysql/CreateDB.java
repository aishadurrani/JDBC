package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class CreateDB {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		String url = "jdbc:mysql://localhost:3306";
		String user = "root";
		String pass = "password";

		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			String sql = "CREATE DATABASE STUDENTS;";
			stmt.executeUpdate("Drop database if exists students");
			stmt.executeUpdate(sql);
			System.out.println("database created successfully...");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
