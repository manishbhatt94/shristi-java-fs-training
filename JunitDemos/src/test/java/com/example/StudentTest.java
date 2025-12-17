package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

	Student student;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	void testTotalSum() {
		int actual = student.totalSum(90, 90, 92);
		assertEquals(272, actual);
	}

	@Test
	void testTotalSum_invalidMarks() {
		assertThrows(InvalidMarksException.class, () -> {
			student.totalSum(-25, 90, 92);
		});
		assertThrows(InvalidMarksException.class, () -> {
			student.totalSum(95, 101, 92);
		});
	}

}
