package com.example;

import java.util.List;

public class Student {

	public int totalSum(int marks1, int marks2, int marks3) {
		List<Integer> marks = List.of(marks1, marks2, marks3);
		boolean invalid = marks.stream().anyMatch((mark) -> mark < 0 || mark > 100);
		if (invalid) {
			throw new InvalidMarksException();
		}
		return marks1 + marks2 + marks3;
	}

}
