package com.training.quest6;

enum CuisineType {
	INDIAN, INTERNATIONAL;
}

enum MealCourse {
	STARTERS, MAINCOURSE, DESSERTS;
}

public interface ICuisine {

	String[] showMenus(MealCourse mealCourse);
}
