package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedSt {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost:3306/students";
		String user = "root";
		String pass = "password";

		try {
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, first, last, age FROM Registration WHERE id<? and age=?";
			stmt = conn.prepareStatement(sql);
//			String sql = "SELECT id, first, last, age FROM Registration" + " ORDER BY first ASC";
			stmt.setInt(1, 105);
			stmt.setInt(2, 40);
			rs = stmt.executeQuery();
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