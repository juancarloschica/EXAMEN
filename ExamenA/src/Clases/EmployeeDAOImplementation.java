package Clases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements CompanyDAO{
	
	private Connection connection;
	
	public EmployeeDAOImplementation() {
		try {
			this.connection = ConnectionDB.getConnection();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sqlAccounting = "SELECT * FROM accounting;";
		String sqlRRHH = "SELECT * FROM RRHH;";
		Statement st;
		ResultSet res;
		try {
			st = connection.createStatement();
			res = st.executeQuery(sqlAccounting);
			while(res.next()) {
				employeeList.add(new Accounting(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4), res.getDouble(5)));
			}
			res = st.executeQuery(sqlRRHH);
			while(res.next()) {
				employeeList.add(new Accounting(res.getString(1), res.getString(2), res.getString(3), res.getDouble(4), res.getInt(5)));
			}
		} catch (SQLException e) {
			System.err.println("Error al obtener los datos de los empleados");
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		String sql;
		PreparedStatement ps;
		
		if (employee instanceof Employee) {
			sql = "INSERT INTO employee (ein, firstname, lastname, salary) VALUES (?, ?, ?, ?);";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, employee.getEin());
				ps.setString(2, employee.getFirstname());
				ps.setString(3, employee.getLastname());
				ps.setDouble(4, employee.getSalary());
			} catch (SQLException e) {
				System.err.println("Error al insertar en la tabla employee");
				e.printStackTrace();
			}
		}
		
		if (employee instanceof Accounting) {
			sql = "INSERT INTO accounting (ein, firstname, lastname, salary, complement) VALUES (?, ?, ?, ?, ?);";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, employee.getEin());
				ps.setString(2, employee.getFirstname());
				ps.setString(3, employee.getLastname());
				ps.setDouble(4, employee.getSalary());
				ps.setDouble(5, ((Accounting) employee).getComplement());
			} catch (SQLException e) {
				System.err.println("Error al insertar en la tabla accounting");
				e.printStackTrace();
			}
		}
		
		if (employee instanceof RRHH) {
			sql = "INSERT INTO rrhh (ein, firstname, lastname, salary, workday) VALUES (?, ?, ?, ?, ?);";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, employee.getEin());
				ps.setString(2, employee.getFirstname());
				ps.setString(3, employee.getLastname());
				ps.setDouble(4, employee.getSalary());
				ps.setInt(5, ((RRHH) employee).getWorkday());
			} catch (SQLException e) {
				System.err.println("Error al insertar en la tabla rrhh");
				e.printStackTrace();
			}
		}
		return false;
	}

}
