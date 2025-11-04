package com.inter.defaultmethod;

public class DefaultMain {

	public static void main(String[] args) {
		IBonusCalculator bonusCalculator = new EmployeeDetails();
		bonusCalculator.calculate(2000.0);
		bonusCalculator.processDetails();

		// Compiler Error: This static method of interface IBonusCalculator can only be accessed as
		// IBonusCalculator.showPolicy();
		// bonusCalculator.showPolicy();

		// Just Warning: The static field IBonusCalculator.DESCRIPTION should be accessed in a static
		// way
		// System.out.println(bonusCalculator.DESCRIPTION); // not recommended way
		// Better is to access using InterfaceName.DESCRIPTION
		System.out.println(IBonusCalculator.DESCRIPTION);
		System.out.println();

		ILoanProcessor loanProcessor = (ILoanProcessor) bonusCalculator;
		loanProcessor.calculate(1000.0);
		loanProcessor.processDetails();
		System.out.println();

		// call interface's static methods using only the interface name
		IBonusCalculator.showPolicy();
	}
}
