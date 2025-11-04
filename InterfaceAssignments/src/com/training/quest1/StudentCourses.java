package com.training.quest1;

public class StudentCourses implements IInstitute {

	@Override
	public String[] showCourses() {
		return new String[] { "Python", "Java", "Data Structures", "Operating Systems" };
	}
}
