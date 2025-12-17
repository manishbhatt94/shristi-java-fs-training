package com.example;

public class ExceedsWithdrawalLimitException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceedsWithdrawalLimitException() {
		super();
	}

	public ExceedsWithdrawalLimitException(String message) {
		super(message);
	}

}
