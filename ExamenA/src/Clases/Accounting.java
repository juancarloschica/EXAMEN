package Clases;

public class Accounting extends Employee {
	
	private double complement;

	public Accounting(String ein, String firstname, String lastname, double salary, double complement) {
		super(ein, firstname, lastname, salary);
		this.complement = complement;
	}

	@Override
	public String toString() {
		return String.format(
			"Accounting [EIN = %s / Firstname = %s / Lastname = %s / Total Salary = %s]", 
			getEin(), getFirstname(), getLastname(), getSalary()+complement
		);
	}

	public double getComplement() {
		return complement;
	}

	public void setComplement(double complement) {
		this.complement = complement;
	}

}
