package exercises.mysql.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl extends AbstractDAO implements ProductDAOI {
	public Product getProductByCode(String code) {
		Product p = null;
		try {
			p = new Product();
			this.connect();
			pst = con.prepareStatement(get_product_by_code);
			pst.setString(1, code);
			rs = pst.executeQuery();

			if (rs.next()) {
				p.setId(rs.getString("productCode"));
				p.setName(rs.getString("productName"));
				p.setPrice(rs.getDouble("buyPrice"));
			}
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public List<Product> getAllProducts() throws SQLException {

		List<Product> pa = new ArrayList<Product>();
		try {
			this.connect();
			pst = con.prepareStatement(get_all_products);
			rs = pst.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getString("productCode"));
				p.setName(rs.getString("productName"));
				p.setPrice(rs.getDouble("buyPrice"));
				pa.add(p);
			}
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pa;
	}

}
