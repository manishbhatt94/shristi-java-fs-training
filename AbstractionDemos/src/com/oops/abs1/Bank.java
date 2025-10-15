package com.oops.abs1;

public abstract class Bank {

	// must be extended
	abstract void carLoan();

	// must be extended
	abstract void eduLoan();

	// must be extended
	abstract void housingLoan();

	// cannot be extended
	final void adminDetails() {
		System.out.println("Bank admin details");
	}
}
