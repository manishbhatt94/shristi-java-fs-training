package com.funcinter.quest1;

public class ShapeMain {

	public static void main(String[] args) {
		System.out.println("Area of various shapes:\n\n");

		IShape shape = null;

		// rectangle
		shape = (length, breadth) -> {
			int area = length * breadth;
			System.out.printf("Area of rectangle (length: %dcm, breadth: %dcm) = %d cm²\n\n", length, breadth, area);
		};
		shape.area(10, 20);

		// triangle
		shape = (base, height) -> {
			double area = 0.5 * base * height;
			System.out.printf("Area of triangle (base: %dcm, height: %dcm) = %.2f cm²\n\n", base, height, area);
		};
		shape.area(15, 5);

		// rhombus
		shape = (diagonal1, diagonal2) -> {
			double area = 0.5 * diagonal1 * diagonal2;
			System.out.printf("Area of rhombus (diagonal1: %dcm, diagonal2: %dcm) = %.2f cm²\n\n", diagonal1, diagonal2,
					area);
		};
		shape.area(30, 12);

		// parallelogram
		shape = (base, height) -> {
			int area = base * height;
			System.out.printf("Area of parallelogram (base: %dcm, height: %dcm) = %d cm²\n\n", base, height, area);
		};
		shape.area(15, 14);
	}
}
