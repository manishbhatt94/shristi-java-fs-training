package com.inher.quest3;

public class Rhombus extends Figure {

	@Override
	void area(int diagonal1, int diagonal2) {
		double result = 0.5 * diagonal1 * diagonal2;
		System.out.println(
				String.format("Area of Rhombus (diagonal1=%dcm, diagonal2=%dcm) is %.2fcm²", diagonal1, diagonal2, result));
	}
}
