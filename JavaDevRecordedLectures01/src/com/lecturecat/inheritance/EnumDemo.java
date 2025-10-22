package com.lecturecat.inheritance;

import java.util.Scanner;

enum Fruits {
	APPLE, MANGO, STRAWBERRY, ORANGE;
}

public class EnumDemo {

	public static void main(String[] args) {
		// convert the enum to an array of elements of the enum type
		Fruits[] fruits = Fruits.values();
		for (Fruits fruit : fruits) {
			System.out.println(fruit.name());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter fruit of choice (APPLE, MANGO, STRAWBERRY, ORANGE):");
		String choice = sc.nextLine();
		sc.close();
		// EnumClass.valueOf(String str) throws IlleggalArgumentException if the 'str'
		// String
		// argument passed to .valueOf() method doesn't match with any of the enum
		// constants
		// declared when the enum was defined
		// Fruits fruit = Fruits.valueOf(choice);

		// So, before directly calling Fruits.valueOf(choice), to avoid Exception in
		// case
		// user enters bad input, we loop over the enum constants and see if the string
		// representation of any of the constants matches with the string which user
		// entered
		Fruits fruit = null;
		for (Fruits fruitConst : fruits) {
			if (fruitConst.name().equals(choice)) {
				fruit = Fruits.valueOf(choice);
			}
		}

		// in case `fruit` stays as null, we can't use switch over it, since switch
		// calls
		// fruit.ordinal() which gives it the numeric or ordinal number of that
		// particular
		// enum constant (zero-based) as in the enum declaration
		// But, here since fruit can be null, we will get a NullPointerException in
		// runtime
		if (fruit == null) {
			System.out.println("Entered invalid fruit of choice (from APPLE, MANGO, STRAWBERRY, ORANGE)." + "\n\""
					+ choice + "\" - no such enum constant is defined in enum Fruits." + "\nExiting!");
			System.exit(0);
		}

		switch (fruit) {
		case APPLE:
			System.out.println("... keeps the doctor away");
			break;

		case MANGO:
			System.out.println("... king of fruits");
			break;

		default:
			System.out.println("No message programmed for this fruit choice");
			break;
		}

		Fruits mango = Fruits.MANGO;
		String str = mango.name();
	}
}
