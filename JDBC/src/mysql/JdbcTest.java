package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			String url = "jdbc:mysql://localhost:3306/classicmodels?useSSL=false";
			String user = "root";
			String password = "password";

//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myConn = DriverManager.getConnection(url, user, password);

			System.out.println("Database connection successful!\n");

			Statement myStmt = myConn.createStatement();

			ResultSet myRs = myStmt.executeQuery("Select * from customers where state = 'NY';");

			while (myRs.next()) {
				System.out.println(myRs.getString(3) + ", " + myRs.getDouble(13));
			}

			myConn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
