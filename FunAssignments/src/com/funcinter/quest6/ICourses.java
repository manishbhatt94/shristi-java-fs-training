package com.funcinter.quest6;

import java.util.Arrays;

@FunctionalInterface
public interface ICourses {

	String[] getCourses(String type);

	static void printCourses(String[] courses, String type) {
		if (courses.length == 0) {
			System.out.printf("No courses available for \"%s\" type.\n", type);
		} else {
			System.out.printf("Courses for \"%s\" type: %s.\n", type, Arrays.toString(courses));
		}
	}
}
