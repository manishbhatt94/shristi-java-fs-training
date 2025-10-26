package com.oops.bean;

public class BeanDemo {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setEmpName("Manish");
		employee.setEmpId(10);
		employee.setSalary(2000.0);
		employee.setMarried(false);

		System.out.println(employee.getEmpName());
		System.out.println(employee.getEmpId());
		System.out.println(employee.getSalary());
		System.out.println(employee.isMarried());

		System.out.println(employee);
	}
}
