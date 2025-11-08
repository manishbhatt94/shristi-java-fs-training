package com.userapp.service;

import java.util.List;

import com.userapp.exception.TooLongPasswordException;
import com.userapp.exception.TooShortPasswordException;
import com.userapp.exception.UsernameAlreadyExistsException;

public class ValidatorServiceImpl implements IValidatorService {

	private static final List<String> registeredUsers = List.of("dr-dre", "50-cent", "k-dot", "nasir-jones");

	@Override
	public boolean validateUsername(String username) throws UsernameAlreadyExistsException {
		if (registeredUsers.contains(username.toLowerCase())) {
			throw new UsernameAlreadyExistsException(
					String.format("Username '%s' already taken. Pick a different one!", username));
		}
		return true;
	}

	@Override
	public boolean validatePassword(String password) throws TooLongPasswordException, TooShortPasswordException {
		if (password.length() < 5) {
			throw new TooShortPasswordException("Password must be at least 5 character long. Pick a longer password!");
		}
		if (password.length() > 16) {
			throw new TooLongPasswordException("Password must be at most 16 characters long. Pick a shorter password!");
		}
		return true;
	}

}
