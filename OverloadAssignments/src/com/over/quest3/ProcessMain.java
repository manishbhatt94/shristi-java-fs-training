package com.over.quest3;

public class ProcessMain {

	public static void main(String[] args) {
		Processor processor = new Processor();

		// square root
		processor.calculate(144.0);

		// product
		processor.calculate(15, 6);

		// difference
		processor.calculate(20.9, 2.11);

		// power
		processor.calculate(3.0, 4);

		// square
		processor.calculate(13);
	}
}
