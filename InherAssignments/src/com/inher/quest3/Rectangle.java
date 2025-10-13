package com.inher.quest3;

public class Rectangle extends Figure {

	@Override
	void area(int length, int breadth) {
		int result = length * breadth;
		System.out.println(
				String.format("Area of Rectangle (length=%dcm, breadth=%dcm) is %dcm²", length, breadth, result));
	}
}
