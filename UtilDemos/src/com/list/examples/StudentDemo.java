package com.list.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class StudentDemo {

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<>();

		students.add(new Student("Jack Sparrow", 32, "Kochi"));
		students.add(new Student("Tony Stark", 17, "Chennai"));
		students.add(new Student("Bruce Wayne", 23, "Mysuru"));
		students.add(new Student("Green Goblin", 20, "Bengaluru"));
		students.add(new Student("Clark Kent", 28, "Bidadi"));
		students.add(new Student("Peter Parker", 30, "Mangaluru"));
		students.add(new Student("Natasha Romanoff", 35, "Udupi"));
		students.add(new Student("Steve Rogers", 19, "Mandya"));
		students.add(new Student("Albus Dumbledore", 19, "Bengaluru"));

		Iterator<Student> it = students.iterator();
		while (it.hasNext()) {
			Student student = it.next();
			System.out.println(student);
		}
		System.out.println();

		Collections.sort(students);
		System.out.println("Sorted by city, then name:");
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
