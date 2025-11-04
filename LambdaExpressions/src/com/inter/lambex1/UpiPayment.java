package com.inter.lambex1;

public class UpiPayment implements IPayment {

	@Override
	public String processPayment(double amount) {
		System.out.println("Payment using UPI");
		if (amount > 5000)
			return "failed";
		return "success";
	}
}
