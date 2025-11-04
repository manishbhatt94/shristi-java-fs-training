package com.inter.lambex1;

public class CardPayment implements IPayment {

	@Override
	public String processPayment(double amount) {
		System.out.println("Payment using Card");
		return "success";
	}
}
