package com.lecturecat.classtypecast;

public class CreditCardPayment extends Payment {

	@Override
	void processPayment(double amount) {
		super.processPayment(amount);
		System.out.println("Payment of amount ₹" + amount + " received using credit card.");
	}

	void applyRewards(int points) {
		System.out.println(points + " reward points applied and discount added.");
	}
}
