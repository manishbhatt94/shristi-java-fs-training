package com.inher.quest3;

public class Triangle extends Figure {

	@Override
	void area(int base, int height) {
		double result = 0.5 * base * height;
		System.out.println(
				String.format("Area of Triangle (base=%dcm, height=%dcm) is %.2fcm²", base, height, result));
	}
}
