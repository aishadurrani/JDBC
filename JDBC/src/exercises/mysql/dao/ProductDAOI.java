package exercises.mysql.dao;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAOI {
	static String get_product_by_code = "SELECT * FROM Products WHERE productCode = ?";
	static String get_all_products = "SELECT * FROM Products limit 10";

	Product getProductByCode(String code) throws SQLException;

	List<Product> getAllProducts() throws SQLException;
}
