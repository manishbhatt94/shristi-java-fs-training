package dev.java.usingComparators;

public class Employee {

	private String firstName;
	private String lastName;
	private String city;
	private int employeeId;
	private double basicSalary;
	private String department;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String city, int employeeId, double basicSalary,
			String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", employeeId="
				+ employeeId + ", basicSalary=" + basicSalary + ", department=" + department + "]";
	}

}
