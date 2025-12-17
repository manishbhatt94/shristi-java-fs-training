package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

	Bank bank;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(8000.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	void testWithdraw() {
		double actual = bank.withdraw(2000.0);
		assertEquals(6000.0, actual);
		// expected, actual, delta
		assertEquals(0.3, 0.1 + 0.2, 0.00001);
	}

	@Test
	void testWithdraw_withdrawalLimitExceeded() {
		assertThrows(ExceedsWithdrawalLimitException.class, () -> {
			bank.withdraw(5100.0);
		});
	}

}
