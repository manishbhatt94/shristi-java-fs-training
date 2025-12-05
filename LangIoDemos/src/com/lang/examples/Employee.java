package com.lang.examples;

import java.util.Objects;

public class Employee {

	private String employeeName;
	private int employeeId;
	private String city;

	public Employee() {
		super();
	}

	public Employee(String employeeName, int employeeId, String city) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.city = city;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, employeeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(employeeName, other.employeeName);
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", city=" + city + "]";
	}

}
