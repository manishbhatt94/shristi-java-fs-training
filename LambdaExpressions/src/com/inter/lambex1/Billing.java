package com.inter.lambex1;

public class Billing {

	public static void main(String[] args) {
		Orders orders = new Orders();

		// create a ref for IPayment
		IPayment payment = new UpiPayment();
		orders.processOrders(payment, 1200, 5);
		System.out.println();

		payment = new CardPayment();
		orders.processOrders(payment, 1100, 3);
		System.out.println();

		System.out.println("Using Lambda expressions");
		IPayment upiPayment = amount -> {
			System.out.println("Payment using UPI for ₹" + amount);
			if (amount > 5000)
				return "failed";
			return "success";
		};
		orders.processOrders(upiPayment, 1500, 2);
		System.out.println();

		orders.processOrders(amount -> {
			System.out.println("Payment using Card for ₹" + amount);
			return "success";
		}, 600, 4);
	}
}
