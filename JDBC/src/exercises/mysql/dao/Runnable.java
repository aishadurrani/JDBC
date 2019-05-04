package exercises.mysql.dao;

import java.sql.SQLException;

public class Runnable {

	public static void main(String[] args) throws SQLException {
		EmployeeRunnable er = new EmployeeRunnable();
		er.getEmployeeById(1056);

		ProductRunnable pr = new ProductRunnable();
		pr.getProductByCode("S10_1949");

		pr.getAllProducts();
	}
}