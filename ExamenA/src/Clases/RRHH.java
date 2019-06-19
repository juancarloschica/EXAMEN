package Clases;

public class RRHH extends Employee{
	
	private int workday;
	
	public RRHH(String ein, String firstname, String lastname, double salary, int workday) {
		super(ein, firstname, lastname, salary);
		this.workday = workday;
	}

	@Override
	public String toString() {
		return String.format(
			"Accounting [EIN = %s / Firstname = %s / Lastname = %s / Workday = %s]", 
			getEin(), getFirstname(), getLastname(), workday
		);
	}

	public int getWorkday() {
		return workday;
	}

	public void setWorkday(int workday) {
		this.workday = workday;
	}

}
