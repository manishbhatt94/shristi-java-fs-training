package com.streams.userdefined;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EmployeeStreams {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee("Raji", 22, 12000, "Goa"),
				new Employee("Aarav", 10, 4500, "Chennai"), new Employee("Nandhu", 82, 8000, "Pune"),
				new Employee("Rakesh", 122, 11200, "Chennai"), new Employee("Kumaran", 120, 14500, "Chennai"),
				new Employee("Harini", 12, 18000, "Pune"));

		employees.stream().filter(emp -> emp.getCity().equals("Chennai")).sorted().forEach(System.out::println);
		System.out.println();

		// @formatter:off
		employees.stream()
				.filter(emp -> emp.getCity().equals("Chennai"))
				.map(Employee::getEmployeeName)
				// .map(emp -> emp.getEmployeeName())
				.sorted().forEach(System.out::println);
		// @formatter:on
		System.out.println();

		// @formatter:off
		double sumSalaries = employees.stream()
				.mapToDouble(Employee::getSalary)
				.sum();
		// @formatter:on
		System.out.println("Sum of salaries = " + sumSalaries);
		System.out.println();

		System.out.println("Custom sort - sorting by employeeId (type Integer - wrapper class)");
		// @formatter:off
		employees.stream()
			// .sorted((o1, o2) -> o1.getEmployeeId().compareTo(o2.getEmployeeId()))
			// .sorted(Comparator.comparing(emp -> emp.getEmployeeId()))
			.sorted(Comparator.comparing(Employee::getEmployeeId))
			.forEach(System.out::println);
		// @formatter:on
		System.out.println();

		System.out.println("Custom sort - sorting by salary (type double - primitive)");
		// @formatter:off
		employees.stream()
			// .sorted((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))
			// .sorted(Comparator.comparing(emp -> emp.getSalary()))
			// .sorted(Comparator.comparing(Employee::getSalary))			// -> natural (ascending order)
			.sorted(Comparator.comparing(Employee::getSalary).reversed())	// -> reversed order (descending)
			.forEach(System.out::println);
		// @formatter:on
		System.out.println();

		System.out.println("Example use of findFirst -- ifPresent. Find employee with id = 12");
		// @formatter:off
		employees.stream()
			.filter(emp -> emp.getEmployeeId() == 12)
			.findFirst()
			.ifPresent(System.out::println);
		// @formatter:on
		System.out.println();

	}

}
