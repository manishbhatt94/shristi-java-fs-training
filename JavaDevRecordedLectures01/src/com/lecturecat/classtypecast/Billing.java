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
		
		// Example of ClassCastException
		// 'payment' reference is currently pointing to a UpiPayment object.
		// If we were mistakenly thinking that it is pointing to a CreditCardPayment object,
		// and accordingly to call own methods of the CreditCardPayment class, we try to
		// cast the 'payment' reference to CreditCardPayment, on runtime we will get a
		// ClassCastException
		// Note that compiler is not able to catch this issue
		// CreditCardPayment creditRef = (CreditCardPayment) payment;
		/**
		 * Exception in thread "main" java.lang.ClassCastException:
		 * class com.lecturecat.classtypecast.UpiPayment cannot be cast to
		 * class com.lecturecat.classtypecast.CreditCardPayment
		 * (com.lecturecat.classtypecast.UpiPayment and com.lecturecat.classtypecast.CreditCardPayment are in module JavaDevRecordedLectures01 of loader 'app')
		 * at JavaDevRecordedLectures01/com.lecturecat.classtypecast.Billing.main(Billing.java:26)
		 */

		payment = new CreditCardPayment();
		payment.processPayment(4500.0);
		payment.refund(750.0);
		CreditCardPayment creditCardPayment = (CreditCardPayment) payment;
		creditCardPayment.applyRewards(45);
	}
}
