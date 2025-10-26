package com.oops.bean;

public class Employee {

	private String empName;
	private double salary;
	private int empId;
	private boolean married;

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", salary=" + salary + ", empId=" + empId + ", married=" + married
				+ "]";
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public boolean isMarried() {
		return married;
	}
}
