package com.inher.quest1;

public class TeamOne extends Project {

	@Override
	void doTask() {
		super.doTask();
		System.out.println("Project implemented using Java");
	}

	void softwaresUsed(String... tools) {
		System.out.println("Softwares used by TeamOne:");
		for (String tool : tools) {
			System.out.println(tool);
		}
	}
}
