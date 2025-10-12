package com.inher.quest1;

public class TeamTwo extends Project {

	@Override
	void doTask() {
		System.out.println("Project implemented using Python");
	}

	String[] getTechStack() {
		return new String[] {"Java", "Spring", "Angular"};
	}
}
