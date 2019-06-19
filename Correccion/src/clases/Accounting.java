package clases;

public class Accounting extends Employee {

	private double complement;
	
	public Accounting(String firstName, String lastName, String ein_employee, double salary, double complement) {
		super(firstName, lastName, ein_employee, salary);
		this.complement = complement;
	}

	@Override
	public String toString() {
		return String.format(
				"First Name: %s, LastName: %s, EIN: %s, Total salary: %.2f",
				getFirstName(), getLastName(), getEin_employee(), getSalary() + complement);
	}
	
	

}
