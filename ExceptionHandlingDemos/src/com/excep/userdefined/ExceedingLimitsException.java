package com.excep.userdefined;

public class ExceedingLimitsException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceedingLimitsException() {
		super();
	}

	public ExceedingLimitsException(String message) {
		super(message);
	}
}
