package com.lang.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashDemo {

	public static void main(String[] args) {

		Employee emp1 = new Employee("Sri", 1, "Pune");
		Employee emp2 = new Employee("Sri", 1, "Pune");
		Employee emp3 = new Employee("Sri", 1, "Chennai");
		Employee emp4 = new Employee("Sri", 2, "Pune");

		System.out.println(emp1.hashCode());
		System.out.println(emp2.hashCode());
		System.out.println(emp3.hashCode());
		System.out.println(emp4.hashCode());

		System.out.println("1&2 " + (emp1.equals(emp2)));
		System.out.println("1&3 " + (emp1.equals(emp3)));
		System.out.println("1&4 " + (emp1.equals(emp4)));
		System.out.println("3&4 " + (emp3.equals(emp4)));

		List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4);
		System.out.println(employees);
		Set<Employee> empset = new HashSet<Employee>(employees);
		System.out.println(empset);

	}

}
