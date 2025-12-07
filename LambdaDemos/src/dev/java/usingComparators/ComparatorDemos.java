package dev.java.usingComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

// Resource link: https://dev.java/learn/lambdas/writing-comparators/#implementing

public class ComparatorDemos {

	public static void main(String[] args) {

		withLambdaOrMethRef();
		comparatorFactoryMethods();
		chainingComparators();
		specializedComparators();
		comparingUsingNaturalOrder();
		reverseOrdering();
		dealingWithNullValues();

	}

	private static void withLambdaOrMethRef() {
		List<Integer> numsList = Arrays.asList(83, 37, 43, 79, 20, 31);

		// Comparator - Using lambda expression
		Comparator<Integer> cmp1 = (i1, i2) -> Integer.compare(i1, i2);
		System.out.println("Unsorted:");
		System.out.println(numsList);

		Collections.sort(numsList);

		System.out.println("Sorted:");
		System.out.println(numsList);
		System.out.println();

		List<Integer> arr = Arrays.asList(83, 37, 43, 79, 20, 31);

		// Comparator - Using method reference
		Comparator<Integer> cmp2 = Integer::compare;
		System.out.println("Unsorted:");
		System.out.println(arr);

		Collections.sort(arr, cmp2);

		System.out.println("Sorted:");
		System.out.println(arr);
		System.out.println();
	}

	private static void comparatorFactoryMethods() {
		// Compare strings by their lengths, not alphabetically.
		// i.e. "rat" (length = 3) is placed before "mango" (length = 5), which is
		// placed before "chocolate" (length = 9)
		// ["rat", "mango", "chocolate"]
		List<String> stuff = Arrays.asList("one", "two", "three", "four", "five");

		// Approach 1 (Basic usage):
		Comparator<String> cmpString1 = (s1, s2) -> Integer.compare(s1.length(), s2.length());

		// Approach 2:
		Function<String, Integer> toLength = String::length;
		Comparator<String> cmpString2 = (s1, s2) -> Integer.compare(toLength.apply(s1), toLength.apply(s2));

		// Approach 3 (use factory method: Comparator.comparing
		Comparator<String> cmpString3 = Comparator.comparing(String::length);

		System.out.println("Unsorted:");
		System.out.println(stuff);

		Collections.sort(stuff, cmpString3);

		System.out.println("Sorted:");
		System.out.println(stuff);
		System.out.println();

		// ====================================================

		// Using Comparator.comparing(..) factory method on a POJO / Java Bean
		List<Employee> employees = getDummyEmployees();

		// Comparing by salary, in natural (ascending order):
		Comparator<Employee> bySalary = Comparator.comparing(Employee::getBasicSalary);

		// System.out.println("Unsorted:");
		// employees.forEach(System.out::println);

		Collections.sort(employees, bySalary);

		System.out.println("Sorted byBasicSalary:");
		employees.forEach(System.out::println);
		System.out.println();
	}

	private static void chainingComparators() {
		// Compare Employee objects using firstName, and then using lastName
		// Using .thenComparing(..) default method of Comparator interface
		List<Employee> employees = getDummyEmployees();

		// Approach 1. When passing a comparator as argument to .thenComparing(..)
		Comparator<Employee> byFirstName = Comparator.comparing(Employee::getFirstName);
		Comparator<Employee> byLastName = Comparator.comparing(Employee::getLastName);
		Comparator<Employee> byFirstNameThenLastName1 = byFirstName.thenComparing(byLastName);

		// Approach 2. When passing a Function (acting as a 'keyExtractor' - like in the
		// case of using .comparing(Function keyExtractor) factory method as argument to
		// .thenComparing(..)
		Comparator<Employee> byFirstNameThenLastName2 = Comparator.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);

		// System.out.println("Unsorted:");
		// employees.forEach(System.out::println);

		Collections.sort(employees, byFirstNameThenLastName2);

		System.out.println("Sorted byFirstNameThenLastName:");
		employees.forEach(System.out::println);
		System.out.println();
	}

	private static void specializedComparators() {
		// For working with primitive types: int, long & double
		// without paying the performance penalty of auto-(un)-boxing

		// Let's say we want to sort Employee's by their basicSalary first, and then by
		// their employeeId
		List<Employee> employees = getDummyEmployees();

		Comparator<Employee> byBasicSalaryThenEmployeeId = Comparator.comparingDouble(Employee::getBasicSalary)
				.thenComparingInt(Employee::getEmployeeId);
		// Note the use of specialized comparator factory / chaining methods like
		// comparingDouble, thenComparingInt being used; instead of comparing,
		// thenComparing.

		// System.out.println("Unsorted:");
		// employees.forEach(System.out::println);

		Collections.sort(employees, byBasicSalaryThenEmployeeId);

		System.out.println("Sorted byBasicSalaryThenEmployeeId:");
		employees.forEach(System.out::println);
		System.out.println();
	}

	private static void comparingUsingNaturalOrder() {
		// Let's say we want to compare string of characters with their length, and then
		// with their natural order (i.e. lexicographically or alphabetically)
		Comparator<String> byLengthThenAlphabetically = Comparator.comparing(String::length)
				.thenComparing(Comparator.naturalOrder());
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");

		System.out.println("Unsorted:");
		System.out.println(strings);

		strings.sort(byLengthThenAlphabetically);

		System.out.println("Sorted:");
		System.out.println(strings);
		System.out.println();
	}

	private static void reverseOrdering() {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");

		strings.sort(Comparator.naturalOrder());

		System.out.println("Sorted (in natural order):");
		System.out.println(strings);

		strings.sort(Comparator.reverseOrder());

		System.out.println("Sorted (in reverse order):");
		System.out.println(strings);
		System.out.println();
	}

	private static void dealingWithNullValues() {
		List<String> strings = Arrays.asList("one", null, "two", "three", null, null, "four", "five");

		System.out.println("Unsorted:");
		System.out.println(strings);

		// Nulls Last
		Comparator<String> naturalNullsLast = Comparator.nullsLast(Comparator.naturalOrder());

		strings.sort(naturalNullsLast);

		System.out.println("Sorted (nulls last):");
		System.out.println(strings);

		// Nulls First
		Comparator<String> naturalNullsFirst = Comparator.nullsFirst(Comparator.naturalOrder());

		strings.sort(naturalNullsFirst);

		System.out.println("Sorted (nulls first):");
		System.out.println(strings);

		System.out.println();
	}

	private static List<Employee> getDummyEmployees() {
		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Amit", "Sharma", "Bangalore", 101, 55000, "Development"));
		employees.add(new Employee("Amit", "Verma", "Hyderabad", 102, 60000, "Testing"));
		employees.add(new Employee("Priya", "Nair", "Chennai", 103, 48000, "HR"));
		employees.add(new Employee("Ravi", "Kumar", "Pune", 104, 75000, "Development"));
		employees.add(new Employee("Sneha", "Patil", "Mumbai", 105, 55000, "Design"));
		employees.add(new Employee("Arjun", "Mehta", "Delhi", 106, 90000, "Management"));
		employees.add(new Employee("Neha", "Singh", "Kolkata", 107, 60000, "Testing"));
		employees.add(new Employee("Vikas", "Reddy", "Hyderabad", 108, 48000, "Support"));
		employees.add(new Employee("Amit", "Joshi", "Bangalore", 109, 55000, "Development"));
		employees.add(new Employee("Kiran", "Desai", "Ahmedabad", 110, 70000, "Design"));
		employees.add(new Employee("Ravi", "Iyer", "Chennai", 111, 75000, "Development"));
		employees.add(new Employee("Meera", "Shah", "Surat", 112, 45000, "HR"));
		employees.add(new Employee("Amit", "Bhat", "Bangalore", 113, 60000, "Support"));
		employees.add(new Employee("Sneha", "Kulkarni", "Mumbai", 114, 55000, "Design"));
		employees.add(new Employee("Ravi", "Menon", "Bangalore", 115, 75000, "Testing"));

		return employees;
	}

}
