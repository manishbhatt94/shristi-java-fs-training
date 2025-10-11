package com.oops.overload;

public class ShapeMain {

	public static void main(String[] args) {
		Shape shape = new Shape();

		shape.area(10);

		shape.area(10.5f);

		int rectArea = shape.area(10, 20);
		System.out.println("Rectangle area = " + rectArea);

		float triArea = shape.area(12, 10.0f);
		System.out.println("Triangle area = " + triArea);
	}
}
