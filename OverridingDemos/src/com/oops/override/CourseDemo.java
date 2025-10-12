package com.oops.override;

import java.util.Arrays;

public class CourseDemo {

	public static void main(String[] args) {
		Course course = new Backend();
		course.trainingInfo();

		String[] backendCourses = course.showCourses();
		System.out.println("Backend courses: " + Arrays.toString(backendCourses));

		course = new Frontend();
		String[] frontendCourses = course.showCourses();
		System.out.println("Frontend courses: " + Arrays.toString(frontendCourses));
	}
}
