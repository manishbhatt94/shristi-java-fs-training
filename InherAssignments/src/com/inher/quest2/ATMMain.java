package com.inher.quest2;

import java.util.Scanner;

public class ATMMain {

	public static void main(String[] args) {
		ATMMain.operateATM();
	}

	private static void operateATM() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Java Bank ATM Menu\n");

		String accountType = null;

		do {
			if (accountType != null) {
				System.out.println("Invalid account type entered. Please try again.");
			}
			System.out.println("Please type your account type ('savings' / 'current'):");
			accountType = sc.nextLine().trim().toLowerCase();
		} while (!Account.validAccountTypes.contains(accountType));

		Account account;

		if (accountType.equals("savings")) {
			System.out.println("Selected savings bank account!");
			account = new Savings();
		} else {
			System.out.println("Selected current bank account!");
			account = new Current();
		}

		while (true) {
			System.out.println("\nJava Bank ATM Menu for your " + accountType + " bank account");
			System.out.println("Select from one of the below choices of commands to operate your account");
			System.out.println("deposit - Deposit cash in your account");
			System.out.println("withdraw - Withdraw cash from your account");
			System.out.println("balance - Check the existing balance of your bank account");
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
