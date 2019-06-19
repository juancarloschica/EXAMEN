package Clases;

public class Employee {
	
	private String ein;
	private String firstname;
	private String lastname;
	private double salary;
	
	public Employee(String EIN, String firstName, String lastName, double salary) {
		super();
		this.ein = EIN;
		this.firstname = firstName;
		this.lastname = lastName;
		this.salary = salary;
	}
	
	public String getEin() {
		return ein;
	}
	
	public void setEin(String ein) {
		this.ein = ein;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ein == null) ? 0 : ein.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (ein == null) {
			if (other.ein != null)
				return false;
		} else if (!ein.equals(other.ein))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [EIN=" + ein + ", firstName=" + firstname + ", lastName=" + lastname + ", salary=" + salary
				+ "]";
	}

}
