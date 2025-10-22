package com.lecturecat.classtypecast;

public class Billing {

	public static void main(String[] args) {
		// super class reference = sub class object
		Payment payment = new CodPayment();
		payment.processPayment(2000.0);
		payment.refund(2000.0);
		System.out.println();

		payment = new UpiPayment();
		payment.processPayment(1200.0);
		payment.refund(200.0);
		UpiPayment upi = (UpiPayment) payment;
		upi.validateUpiId(1234);
		System.out.println();

		payment = new CreditCardPayment();
		payment.processPayment(4500.0);
		payment.refund(750.0);
		CreditCardPayment creditCardPayment = (CreditCardPayment) payment;
		creditCardPayment.applyRewards(45);
	}
}
