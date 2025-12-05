package com.lang.examples;

public class CloneDemo {

	public static void main(String[] args) {

		Student student1 = new Student("Morgan Freeman", 1, "Bengaluru");
		System.out.println("student1: " + student1);
		try {
			Student student2 = (Student) student1.clone();
			System.out.println("student2: " + student2);
			System.out.println("(student1 == student2) = " + (student1 == student2));
			System.out.println(student1.getClass());
			System.out.println(student2.getClass());
			System.out.println(
					"student1.getClass() == student2.getClass() = " + (student1.getClass() == student2.getClass()));
			student2.setStudentName("Christian Bale");
			System.out.println("student2.getStudentName() = " + student2.getStudentName());
			System.out.println("student1.getStudentName() = " + student1.getStudentName());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
