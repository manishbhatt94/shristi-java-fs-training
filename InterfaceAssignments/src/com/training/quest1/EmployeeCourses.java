package com.training.quest1;

public class EmployeeCourses implements IInstitute {

	@Override
	public String[] showCourses() {
		return new String[] { "Agile", "Scrum", "Deployment", "Cloud Computing" };
	}
}
