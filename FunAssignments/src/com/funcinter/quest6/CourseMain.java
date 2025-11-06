package com.funcinter.quest6;

public class CourseMain {

	public static void main(String[] args) {
		System.out.println("Courses for various domains in Software Development\n\n");

		System.out.println("▶️ Courses in Frontend domain:\n");
		ICourses frontendCourses = type -> {
			switch (type) {
			case "design":
				return new String[] { "HTML", "CSS", "Bootstrap", "Material" };

			case "development":
				return new String[] { "HTML", "CSS", "React", "Angular" };

			default:
				return new String[] {};
			}
		};
		ICourses.printCourses(frontendCourses.getCourses("design"), "design");
		ICourses.printCourses(frontendCourses.getCourses("development"), "development");
		ICourses.printCourses(frontendCourses.getCourses("analytics"), "analytics");
		System.out.println();

		System.out.println("▶️ Courses in Backend domain:\n");
		ICourses backendCourses = type -> {
			switch (type) {
			case "java":
				return new String[] { "Spring", "Hibernate" };

			case "python":
				return new String[] { "Django", "Flask" };

			default:
				return new String[] {};
			}
		};
		ICourses.printCourses(backendCourses.getCourses("java"), "java");
		ICourses.printCourses(backendCourses.getCourses("python"), "python");
		ICourses.printCourses(backendCourses.getCourses("caching"), "caching");
		System.out.println();

		System.out.println("▶️ Courses in Database domain:\n");
		ICourses databaseCourses = type -> {
			switch (type) {
			case "sql":
				return new String[] { "MySQL", "Oracle" };

			case "nosql":
				return new String[] { "MongoDB", "CouchDB" };

			default:
				return new String[] {};
			}
		};
		ICourses.printCourses(databaseCourses.getCourses("sql"), "sql");
		ICourses.printCourses(databaseCourses.getCourses("nosql"), "nosql");
		ICourses.printCourses(databaseCourses.getCourses("db-admin"), "db-admin");
		System.out.println();
	}
}
