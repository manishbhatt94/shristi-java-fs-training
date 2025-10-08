package com.oops.basics;

import java.util.Arrays;

public class ProjectMain {

	public static void main(String[] args) {
		Project prj1 = new Project();
		String[] prj1Tools = prj1.showTools();
		System.out.println(Arrays.toString(prj1Tools));
		System.out.println(prj1.projectInfo());
	}
}
