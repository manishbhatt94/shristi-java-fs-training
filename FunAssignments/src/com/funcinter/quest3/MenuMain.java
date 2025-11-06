package com.funcinter.quest3;

import java.util.Arrays;

public class MenuMain {

	public static void main(String[] args) {
		System.out.println("Menu for different meal courses:\n\n");

		IMenu menu = null;

		// starters course
		menu = items -> System.out.println("Starter course items: " + Arrays.toString(items) + "\n");
		menu.printMenu(new String[] { "Samosa", "Paneer Tikka", "Aloo Tikki", "Vada" });

		// main course
		menu = items -> System.out.println("Main course items: " + Arrays.toString(items) + "\n");
		menu.printMenu(new String[] { "Butter Chicken", "Palak Paneer", "Dal Makhani", "Chole Bhature" });

		// desserts course
		menu = items -> System.out.println("Dessert course items: " + Arrays.toString(items) + "\n");
		menu.printMenu(new String[] { "Gulab Jamun", "Jalebi", "Rasmalai", "Gajar ka Halwa" });
	}
}
