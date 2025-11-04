package com.inter.lambex1;

public class Orders {

	void processOrders(IPayment payment, double cost, int quantity) {
		System.out.println("Process orders");
		double amount = cost * quantity;
		System.out.println("Amount to be paid = " + amount);
		String status = payment.processPayment(amount);
		if (status.equals("success"))
			System.out.println("Order shipped");
		else
			System.out.println("Payment failed");
	}
}
