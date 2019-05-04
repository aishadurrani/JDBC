package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertV {
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
			String sql = "INSERT INTO registration (id, age, first, last) values " + "(100, 29, 'Micheal', 'Jordan'),"
					+ "(101, 29, 'Diego', 'Maradona')," + "(102, 33, 'Babe', 'Ruth'),"
					+ "(103, 40, 'Wayne', 'Gretzky')," + "(104, 40, 'Michelle', 'Kwan'),"
					+ "(105, 35, 'Steffi', 'Graf')";
			stmt.executeUpdate(sql);
			System.out.println("Values inserted successfully...");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}