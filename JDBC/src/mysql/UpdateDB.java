package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDB {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/students";
		String user = "root";
		String pass = "password";

		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
//			String sql = "SELECT id, first, last, age FROM Registration" + " ORDER BY first ASC";
			String sql = "SELECT id, first, last, age FROM Registration" + " WHERE first LIKE '%ich%'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getString("last");
				System.out.println("ID: " + id + ", AGE: " + age + ", FIRST: " + first + ", LAST: " + last);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
