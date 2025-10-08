package com.basics.quest2;

import java.util.Scanner;

public class BankMain {

	public static void main(String[] args) {
		Bank account = new Bank(0.0);
		BankMain.operateBankAccount(account);
	}

	private static void operateBankAccount(Bank account) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Java Bank ATM Menu - Select a choice");
			System.out.println("deposit - Deposit cash in your account");
			System.out.println("withdraw - Withdraw cash from your account");
			System.out.println("balance - Check the current balance of your bank account");
			System.out.println("exit - Exit the ATM menu");
			System.out.print("\nYour choice? ");
			String choice = sc.next().trim().toLowerCase();

			switch (choice) {
			case "deposit":
				System.out.print("Enter an amount to deposit: ");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;

			case "withdraw":
				System.out.print("Enter an amount to withdraw: ");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;

			case "balance":
				System.out.println(String.format("Your account balance is ₹%.2f", account.getBalance()));
				break;

			case "exit":
				System.out.println("Thanks for using Java ATM services. See you again.");
				break;

			default:
				System.out.println("Invalid choice. Try again!");
				break;
			}

			if (choice.equals("exit")) {
				break;
			} else {
				System.out.println("\n");
			}
		}

		sc.close();
	}
}
