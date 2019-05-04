package exercises.mysql.dao;

import java.sql.SQLException;
import java.util.List;

public class ProductRunnable {

	void getProductByCode(String code) {
		ProductDAOImpl cdi = new ProductDAOImpl();

		Product p = cdi.getProductByCode(code);
		System.out.println("Code : " + p.getId());
		System.out.println("Name : " + p.getName());
		System.out.println("Price: " + p.getPrice());
		System.out.println();
	}

	void getAllProducts() throws SQLException {
		ProductDAOImpl cdi = new ProductDAOImpl();
		List<Product> pl = cdi.getAllProducts();
		for (Product p : pl) {
			System.out.print("Code: " + p.getId());
			System.out.print("\tPrice: " + p.getPrice());
			System.out.print("\tName: " + p.getName());
			System.out.println();
		}

	}
}
