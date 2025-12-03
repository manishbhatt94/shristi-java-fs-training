package com.streams.userdefined;

public class Employee implements Comparable<Employee> {

	private String employeeName;
	private Integer employeeId;
	private double salary;
	private String city;

	public Employee() {
		super();
	}

	public Employee(String employeeName, Integer employeeId, double salary, String city) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.salary = salary;
		this.city = city;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", salary=" + salary
				+ ", city=" + city + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return employeeName.compareTo(o.getEmployeeName());
	}

}
