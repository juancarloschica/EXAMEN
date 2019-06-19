package clases;

public class RRHH extends Employee {
	
	private int workday;
	
	public RRHH(String firstName, String lastName, String ein_employee, double salary, int workday) {
		super(firstName, lastName, ein_employee, salary);
		this.workday = workday;
	}

	public int getWorkday() {
		return workday;
	}

	public void setWorkday(int workday) {
		this.workday = workday;
	}

	@Override
	public String toString() {
		return String.format(
				"First Name: %s, Last name: %s, EIN :%s, Salary %s, Workday: %d",
				getFirstName(), getLastName(), getEin_employee(), getSalary(), workday);
	}
	
}
