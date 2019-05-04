package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		String url = "jdbc:mysql://localhost:3306/students";
		String user = "root";
		String pass = "password";

		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			String sql = "CREATE TABLE Registration (id INTEGER, age INTEGER, "
					+ "first VARCHAR (50), last VARCHAR (50))";
			stmt.executeUpdate(sql);
			System.out.println("table created successfully...");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
