package com.inher.quest1;

public class CompanyMain {

	public static void main(String[] args) {
		Project project;
		
		System.out.println("Info about Team One's project");
		
		project = new TeamOne();
		project.doTask();
		TeamOne teamOneProject = (TeamOne) project;
		teamOneProject.softwaresUsed("Eclipse", "Jenkins", "Maven");
		System.out.println();

		System.out.println("Info about Team Two's project");
		
		project = new TeamTwo();
		project.doTask();
		TeamTwo teamTwoProject = (TeamTwo) project;
		String[] techStack = teamTwoProject.getTechStack();
		System.out.println("TeamTwo's tech stack:");
		for (String tech : techStack) {
			System.out.println(tech);
		}
	}
}
