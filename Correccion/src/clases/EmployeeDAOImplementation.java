package clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements CompanyDAO {

	private Connection connection;
	
	public EmployeeDAOImplementation() {
		try {
			this.connection = ConnectionDB.getConnection();
		} catch (FileNotFoundException e) {
			System.err.println("Can't find the file!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("I/O ERROR!");
			System.exit(2);
		} catch (SQLException e) {
			System.err.println("SQL ERROR!");
			System.exit(3);
		}
	}
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sqlAccounting = "SELECT * FROM accountig_view;";
		String sqlRRHH = "SELECT * FROM rrhh_view;";
		Statement st;
		ResultSet result;
		try {
			st = connection.createStatement();
			result = st.executeQuery(sqlAccounting);
			while (result.next()) {
				employees.add(new Accounting(result.getString(1), result.getString(2), result.getString(3), result.getDouble(4), result.getDouble(5)));
			}
			result = st.executeQuery(sqlRRHH);
			while (result.next()) {
				employees.add(new RRHH(result.getString(1), result.getString(2), result.getString(3), result.getDouble(4), result.getInt(5)));
			}
		} catch (SQLException e) {
			System.err.println("Error getting Employees!");
		}
		
		return employees;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		String sql = "DELETE FROM employee where ein_employee = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, employee.getEin_employee());
			return ps.executeUpdate() != 0;
		} catch (SQLException e) {
			System.err.println("Error deleting Employee!");
			e.printStackTrace();
		}
		return false;
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error closing the connection!");
		}
	}

}
