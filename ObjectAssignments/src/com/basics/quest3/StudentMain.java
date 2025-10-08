package com.basics.quest3;

import java.util.Arrays;
import java.util.Scanner;

public class StudentMain {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		Student s1 = StudentMain.readStudent();
		s1.printDetails();
		StudentMain.printStudentGrade(s1);

		Student s2 = StudentMain.readStudent();
		s2.printDetails();
		StudentMain.printStudentGrade(s2);

		sc.close();
	}

	private static Student readStudent() {
		System.out.println("\nInput new student info:");

		System.out.print("Enter student name: ");
		String name = sc.nextLine();

		System.out.print("Enter student department: ");
		String department = sc.nextLine();

		Student student = new Student(name, department);
		return student;
	}

	private static void printStudentGrade(Student student) {
		int[] marks = StudentMain.readStudentMarks(student);
		String grade = student.getGrades(marks);
		System.out.println("\nGrade for student " + student.name + " with below marks:");
		System.out.println("(Marks: " + Arrays.toString(marks) + ")");
		System.out.println("Grade = " + grade);
	}

	private static int[] readStudentMarks(Student student) {
		int SUBJECTS_COUNT = 5;

		System.out.println("\nEnter marks for student " + student.name + ":");
		System.out.println("(Enter marks for " + SUBJECTS_COUNT
				+ " subjects in the next line, as non-negative integers, separated by spaces)");
		System.out.println("Enter below: ");

		String line = sc.nextLine();
		String[] marks = line.trim().split("\\s+");

		int[] marksInt = new int[SUBJECTS_COUNT];

		for (int i = 0; i < SUBJECTS_COUNT; i++) {
			marksInt[i] = Integer.parseInt(marks[i]);
		}

		return marksInt;
	}
}
