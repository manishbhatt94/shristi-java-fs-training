package com.training.quest6;

public class Indian implements ICuisine {

	@Override
	public String[] showMenus(MealCourse mealCourse) {
		switch (mealCourse) {
		case STARTERS:
			return new String[] { "Samosa", "Paneer Tikka", "Aloo Tikki", "Vada" };

		case MAINCOURSE:
			return new String[] { "Butter Chicken", "Palak Paneer", "Dal Makhani", "Chole Bhature" };

		case DESSERTS:
			return new String[] { "Gulab Jamun", "Jalebi", "Rasmalai", "Gajar ka Halwa" };

		default:
			return null;
		}
	}
}
