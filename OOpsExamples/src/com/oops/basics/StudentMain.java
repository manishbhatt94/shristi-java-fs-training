package com.oops.basics;

public class StudentMain {

	public static void main(String[] args) {
		Student student1 = new Student();
		student1.studId = 1;
		student1.name = "Varun";
		student1.department = "Civil Engineering";
		student1.getDetails();

		String result = student1.greet();
		System.out.println(result);
		double avg = student1.printAvg(90, 80);
		System.out.println("Average: " + avg);

		System.out.println();

		Student student2 = new Student();
		student2.studId = 2;
		student2.name = "Vaibhav";
		student2.department = "Mathematics";
		student2.getDetails();

		System.out.println(student2.greet());
		System.out.println("Average: " + student2.printAvg(80, 96));

		System.out.println();

		int average = (int) student1.printAvg(98, 99);
		System.out.println(average);
	}
}
