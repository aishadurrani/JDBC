package exercises.mysql.dao;

import java.sql.SQLException;

public class EmployeeRunnable {
	void getEmployeeById(int id) throws SQLException {
		EmployeeDAOImpl cdi = new EmployeeDAOImpl();

		Employee e = cdi.getEmployeeById(id);
		System.out.println("ID: " + e.getId());
		System.out.println("Email: " + e.getEmail());
		System.out.println("fname: " + e.getFname());
		System.out.println("lname: " + e.getLname());
		System.out.println();
	}
}
