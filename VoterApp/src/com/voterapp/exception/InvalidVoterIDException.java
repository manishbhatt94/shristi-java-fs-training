package com.voterapp.exception;

public class InvalidVoterIDException extends NotEligibleException {

	private static final long serialVersionUID = 1L;

	public InvalidVoterIDException() {
		super();
	}

	public InvalidVoterIDException(String message) {
		super(message);
	}

}
