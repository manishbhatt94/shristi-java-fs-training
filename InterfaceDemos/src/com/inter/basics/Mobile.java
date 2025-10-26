package com.inter.basics;

public class Mobile implements IInsurance {

	@Override
	public void getPolicyDetails() {
		System.out.println("Policy for smartphones");
	}
	
	void showApps() {
		System.out.println("WhatsApp, IndianExpress, SBI Yono");
	}
}
