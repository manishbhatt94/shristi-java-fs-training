package com.inher.quest3;

public class OverMain {

	public static void main(String[] args) {
		Figure[] figures = { new Rectangle(), new Triangle(), new Rhombus(), new Parallelogram() };

		System.out.println("Area of various 2D shapes:\n");

		for (Figure figure : figures) {
			figure.area(12, 30);
			System.out.println();
		}
	}
}
