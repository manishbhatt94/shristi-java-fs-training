package com.training.quest5;

import java.util.Arrays;
import java.util.Scanner;

public class Customer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"Enter which type of phone you want to purchase, whether a touchscreen phone or a basic feature phone");
		System.out.print("Enter your choice ('basic' / 'touch'): ");
		String phoneChoice = scanner.next().toLowerCase();

		scanner.close();

		switch (phoneChoice) {
		case "basic":
			System.out.println("\nUsing basic phone:\n");
			IFeaturePhone.brandInfo();
			IFeaturePhone basicPhone = new BasicMobile();
			Customer.doBasicPhoneFunctionality(basicPhone);
			basicPhone.playGames();
			break;

		case "touch":
			System.out.println("\nUsing touch screen phone:\n");
			ISmartPhone.brandInfo();
			ISmartPhone smartPhone = new TouchScreenMobile();
			Customer.doBasicPhoneFunctionality(smartPhone);
			System.out.println("Installed Apps on Touch Screen phone: " + Arrays.toString(smartPhone.showApps()));
			smartPhone.useCamera();
			smartPhone.payBills("groceries");
			smartPhone.downloadMusic();
			smartPhone.playGames();
			break;

		default:
			System.out.println("Invalid choice entered. Re-run the program & try again.");
			System.exit(0);
		}
	}

	public static void doBasicPhoneFunctionality(IFeaturePhone phone) {
		phone.call();
		phone.messaging();
	}
}
