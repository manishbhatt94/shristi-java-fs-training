package com.basics.quest5;

public class MobileMain {

	public static void main(String[] args) {
		Mobile[] mobileArray = MobileMain.getTopMobiles();

		System.out.println("Printing the Top 5 Mobiles on Sale");
		for (Mobile mobile : mobileArray) {
			mobile.getDetails();
		}

		System.out.println("\nMobiles of 'Samsung' brand:");
		for (Mobile mobile : mobileArray) {
			if (mobile.brand.toLowerCase().equals("samsung")) {
				mobile.getDetails();
			}
		}
	}

	private static Mobile[] getTopMobiles() {
		// (String model, String brand, String color, double price)
		String[][] mobilesData = { { "iPhone 17 Pro Max", "Apple", "Cosmic Orange", "149900" },
				{ "Galaxy Z Fold 7", "Samsung", "Blue Shadow", "174999" }, { "13s", "OnePlus", "Green Silk", "50999" },
				{ "15 Ultra", "Xiaomi", "Arctic White", "109999" },
				{ "Galaxy S25 Ultra", "Samsung", "Satin Pink", "98490" }, };
		Mobile[] mobiles = new Mobile[mobilesData.length];

		for (int i = 0; i < mobilesData.length; i++) {
			String[] data = mobilesData[i];
			mobiles[i] = new Mobile(data[0], data[1], data[2], Double.parseDouble(data[3]));
		}

		return mobiles;
	}
}
