package com.training.quest6;

import java.util.Arrays;
import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter cuisine choice ('Indian' / 'International'):");
		String cuisineInput = scanner.next();
		CuisineType cuisineType = CuisineType.valueOf(cuisineInput.toUpperCase());

		System.out.println("\nEnter choice of meal course");
		System.out.println("Choose from 'starters' / 'maincourse' / 'desserts':");
		String mealCourseInput = scanner.next();
		MealCourse mealCourse = MealCourse.valueOf(mealCourseInput.toUpperCase());
		scanner.close();

		System.out.println();

		ICuisine cuisine = null;

		switch (cuisineType) {
		case INDIAN:
			System.out.println("Indian cuisine menu for " + mealCourseInput + " course:");
			cuisine = new Indian();
			break;

		case INTERNATIONAL:
			System.out.println("International cuisine menu for " + mealCourseInput + " course:");
			cuisine = new International();
			break;

		default:
			System.out.println("Invalid choice of cuisine entered. Re-run the program & try again.");
			System.exit(0);
		}

		System.out.println(Arrays.toString(cuisine.showMenus(mealCourse)));
	}
}
