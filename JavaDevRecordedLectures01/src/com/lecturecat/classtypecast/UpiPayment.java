package com.lecturecat.classtypecast;

public class UpiPayment extends Payment {

	@Override
	void processPayment(double amount) {
		super.processPayment(amount);
		System.out.println("Payment of amount ₹" + amount + " received using UPI.");
	}

	void validateUpiId(int upiId) {
		System.out.println("Validated UPI ID: " + upiId);
	}
}
