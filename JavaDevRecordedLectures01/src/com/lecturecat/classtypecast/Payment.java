package com.lecturecat.classtypecast;

public class Payment {

	void processPayment(double amount) {
		System.out.println("Received amount ₹" + amount);
	}

	void refund(double amount) {
		System.out.println("Amount refunded ₹" + amount);
	}
}
