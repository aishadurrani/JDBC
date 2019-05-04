package exercises.mysql.dao;

import java.sql.SQLException;

public interface EmployeesDAOI {
	static String get_employee_by_id = "SELECT * FROM employees WHERE employeeNumber = ?";
	static String add_employee= "INSERT INTO employees VALUES (?,?,?)";
	static String remove_employee_by_id = "DELETE FROM employees WHERE employeeNumber = ?";
	
	Employee getEmployeeById(int id) throws SQLException;
	
}
