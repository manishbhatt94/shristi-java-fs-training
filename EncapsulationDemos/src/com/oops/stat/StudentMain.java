package com.oops.stat;

import static com.oops.stat.Student.printMessage;
import static com.oops.stat.Student.collegeName;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class StudentMain {
	
	static {
		System.out.println("In StudentMain class's static block");
	}

	public static void main(String[] args) {
		System.out.println("main class StudentMain 's - main method");
		
		// until we refer to Student class, JVM will not get an entry into
		// the Student class, so even it's static blocks will not get executed
		
		// so either create an object of Student class
		// Student student = new Student();
		
		// or access its static members
		// Student.printMessage();
		
		/**
		 * Using static imported members
		 */
		printMessage();
		System.out.println(collegeName);
		out.println("parseInt(\"5\") = " + parseInt("5"));
	}
}
