package com.excep.throwsdemo;

public class ATM {

	public static void main(String[] args) {
		System.out.println("In ATM");
		Bank bank = new Bank();
		try {
			bank.withdraw(0);
			System.out.println("Amount withdrawn successfully");
		} catch (Exception e) {
			System.out.println("Exception...");
			System.out.println("Try again");
		}
		System.out.println("Goodbye");
	}
}
