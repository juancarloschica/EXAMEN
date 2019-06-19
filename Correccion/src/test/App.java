package test;

import java.util.List;
import java.util.Scanner;

import clases.Accounting;
import clases.CompanyDAO;
import clases.Employee;
import clases.EmployeeDAOImplementation;
import clases.RRHH;

public class App {
	
	private static EmployeeDAOImplementation em = new EmployeeDAOImplementation();
	private static Scanner sc = new Scanner(System.in);
	private static List<Employee> employees;
	public static void main(String[] args) {
		employees = em.getEmployees();
		String selection = "-1";
		do {
			menu();
			selection = sc.nextLine();
			switch (selection) {
			case "1":
				getAccounting();
				break;
			case "2":
				getRRHH();
				break;
			case "3":
				deleteEmployee();
				break;
			case "0":
				em.closeConnection();
				System.exit(0);
			default:
				break;
			}
		} while (selection != "0");
	}
	
	public static void menu() {
		System.out.println("1.- Show employees from Accounting");
		System.out.println("2.- Show employees from Human Resources");
		System.out.println("3.- Delete employee by its EIN");
	}
	
	public static void getAccounting() {
		System.out.println("SHOWING ACCOUNTING EMPLOYEES");
		for (Employee employee : employees) {
			if (employee instanceof Accounting)
				System.out.println(employee);
		}
		System.out.println(System.lineSeparator());
	}
	
	public static void getRRHH() {
		System.out.println("SHOWING HUMAN RESOURCES EMPLOYEES");
		for (Employee employee : employees) {
			if (employee instanceof RRHH)
				System.out.println(employee);
		}
		System.out.println(System.lineSeparator());
	}
	
	public static void deleteEmployee() {
		String ein;
		do {
			System.out.println("Type the EIN:");
			ein = sc.nextLine();
		}while (!CompanyDAO.checkEIN(ein));
		Employee employee = new Employee("", "", ein, 0);
		if (em.deleteEmployee(employee)) {
			System.out.println("That Employee has been deleted.");
			employees = em.getEmployees();
		} else {
			System.out.println("There is no EIN associated with any employee, aborting...");
		}
	}

}
