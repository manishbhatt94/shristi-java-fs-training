package com.excep.userdefined;

public class MinBalanceException extends Exception {

	private static final long serialVersionUID = 1L;

	public MinBalanceException() {
		super();
	}

	public MinBalanceException(String message) {
		super(message);
	}
}
