package com.list.comp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeCompare {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("Raji", 22, "Goa"), new Employee("Arav", 10, "Chennai"),
				new Employee("Nandhu", 82, "Pune"));

		Comparator<Employee> comp = (o1, o2) -> {
			return o1.getEmployeeName().compareTo(o2.getEmployeeName());
		};
		Collections.sort(employees, comp);
		System.out.println(employees);
		System.out.println();

		Collections.sort(employees, (o1, o2) -> {
			// Sorting by city in reverse order.
			// Note: we switched order by calling compareTo on o2.getCity()
			return o2.getCity().compareTo(o1.getCity());
		});
		System.out.println(employees);
		System.out.println();

		Collections.sort(employees, (o1, o2) -> Integer.compare(o1.getEmployeeId(), o2.getEmployeeId()));
		System.out.println(employees);

	}

}
