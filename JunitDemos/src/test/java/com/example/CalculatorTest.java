package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	Calculator calculator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Called before all tests");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Called after all tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Called before each test");
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Called after each test");
		calculator = null;
	}

	@DisplayName("Test add method")
	@Test
	void testAdd() {
		int actual = calculator.add(10, 20);
		assertEquals(30, actual, "Expected 30");
	}

	@DisplayName("Test sayHello method")
	@Test
	void testSayHello() {
		String expected = "Hello PRIYA";
		String actual = calculator.sayHello("Priya");
		assertEquals(expected, actual);
	}

	@DisplayName("Test sayHello method - Null argument")
	@Test
	void testSayHello_null() {
		String expected = "Hello PRIYA";
		String actual = calculator.sayHello("Priya");
		assertEquals(expected, actual);
	}

}
