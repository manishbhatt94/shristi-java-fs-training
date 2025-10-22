package com.lecturecat.classtypecast;

public class CodPayment extends Payment {

	@Override
	void processPayment(double amount) {
		super.processPayment(amount);
		System.out.println("Payment of amount ₹" + amount + " received using cash on delivery (COD).");
	}
}
