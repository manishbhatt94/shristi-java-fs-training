package com.inher.quest3;

public class Parallelogram extends Figure {

	@Override
	void area(int base, int height) {
		int result = base * height;
		System.out.println(
				String.format("Area of Parallelogram (base=%dcm, height=%dcm) is %dcm²", base, height, result));
	}
}
