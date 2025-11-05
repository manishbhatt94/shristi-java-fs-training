package com.training.quest6;

public class International implements ICuisine {

	@Override
	public String[] showMenus(MealCourse mealCourse) {
		switch (mealCourse) {
		case STARTERS:
			return new String[] { "Caprese Salad", "Bruschetta", "French Onion Soup", "Shrimp Cocktail" };

		case MAINCOURSE:
			return new String[] { "Steak Frites", "Spaghetti Carbonara", "Paella", "Roast Chicken" };

		case DESSERTS:
			return new String[] { "Tiramisu", "Crème brûlée", "Cheesecake", "Apple Pie" };

		default:
			return null;
		}
	}
}
