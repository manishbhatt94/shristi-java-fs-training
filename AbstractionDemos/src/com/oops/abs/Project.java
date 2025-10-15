package com.oops.abs;

public class Project {

	public static void main(String[] args) {
		TeamLead teamLead = new GroupOne();
		teamLead.doTask();

		GroupOne groupOne = (GroupOne) teamLead;
		groupOne.printTools();

		teamLead = new GroupTwo();
		teamLead.doTask();

		teamLead.projectInfo();
	}
}
