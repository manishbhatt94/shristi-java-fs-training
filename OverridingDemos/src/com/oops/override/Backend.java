package com.oops.override;

public class Backend extends Course {

	@Override
	String[] showCourses() {
		return new String[] {"SQL", "Networking"};
	}
}
