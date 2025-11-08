package com.except.slides.quiz02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class Super {
	void m1() throws IOException {
		// dummy code
		FileInputStream fx = new FileInputStream("input.txt");
	}
}

class Sub extends Super {

	@Override
	void m1() throws FileNotFoundException {
		FileInputStream fx = new FileInputStream("output.txt");
	}

}

public class Test {

	public static void main(String[] args) {

	}
}
