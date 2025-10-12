package com.oops.override;

public class Frontend extends Course {

	@Override
	String[] showCourses() {
		return new String[] {"CSS", "PWA", "Browser Extension"};
	}
}
