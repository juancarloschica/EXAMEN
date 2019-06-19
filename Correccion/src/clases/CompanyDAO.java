package clases;

import java.util.List;

public interface CompanyDAO {
	
	List<Employee> getEmployees();
	boolean deleteEmployee(Employee employee);
	static boolean checkEIN(String ein) {
		return ein.matches("\\d{2}-\\d{7}");
	}
}
