package exercises.mysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
	private String url = "jdbc:mysql://localhost:3306/classicmodels?useSSL=false";
	private String user = "root";
	private String password = "password";
	
	protected Connection con = null;
	protected Statement st = null;
	protected PreparedStatement pst = null;
	protected ResultSet rs = null;
	
	public void connect() throws SQLException{
		con = DriverManager.getConnection(url,user,password);
	}
	
	public void dispose() throws SQLException{
		if(!con.equals(null) && !con.isClosed()) {
			con.close();
		}
	}
}
