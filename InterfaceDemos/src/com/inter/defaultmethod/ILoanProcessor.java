package com.inter.defaultmethod;

public interface ILoanProcessor {

	void calculate(double amount);

	default void processDetails() {
		System.out.println("Processing loan");
	}
}
