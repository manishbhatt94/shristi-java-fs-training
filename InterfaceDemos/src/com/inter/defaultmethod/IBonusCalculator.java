package com.inter.defaultmethod;

public interface IBonusCalculator {

	// variables in an interface
	// are by default - public static final
	String DESCRIPTION = "Bonus Calculator Processor";
	double BASEAMOUNT = 1000;

	// by default - public & abstract
	void calculate(double amount);

	// default methods
	// can be overridden
	// by default it is public ONLY
	// used for adding a NEW functionality to an existing interface
	default void processDetails() {
		System.out.println("Processing bonus");
	}

	// static methods
	// CANNOT be overridden
	// by default it is public ONLY
	// used for adding a COMMON functionality for all implementation classes
	static void showPolicy() {
		System.out.println("Bonus policy");
	}
}
