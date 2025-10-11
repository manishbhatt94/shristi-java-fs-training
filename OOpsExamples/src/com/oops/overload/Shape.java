package com.oops.overload;

public class Shape {

	void area(int side) {
		// Area of a Square
		System.out.println("Square's area = " + (side * side));
	}

	int area(int length, int breadth) {
		// Area of a Rectangle
		return length * breadth;
	}

	void area(float radius) {
		// Area of a Circle
		System.out.println("Circle's area = " + (Math.PI * radius * radius));
	}

	float area(int base, float height) {
		return 0.5f * base * height;
	}
}
