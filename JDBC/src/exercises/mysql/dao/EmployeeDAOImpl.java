package exercises.mysql.dao;

public class EmployeeDAOImpl extends AbstractDAO implements EmployeesDAOI {
	@Override
	public Employee getEmployeeById(int id) {
		Employee c = null;
		try {
			c = new Employee();
			this.connect();
			pst = con.prepareStatement(get_employee_by_id);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				c.setId(rs.getInt("employeeNumber"));
				c.setFname(rs.getString("firstName"));
				c.setLname(rs.getString("lastName"));
				c.setEmail(rs.getString("email"));
			}
			this.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;

	}
}