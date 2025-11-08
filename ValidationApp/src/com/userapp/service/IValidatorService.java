package com.userapp.service;

import com.userapp.exception.TooLongPasswordException;
import com.userapp.exception.TooShortPasswordException;
import com.userapp.exception.UsernameAlreadyExistsException;

public interface IValidatorService {

	boolean validateUsername(String username) throws UsernameAlreadyExistsException;

	boolean validatePassword(String password) throws TooLongPasswordException, TooShortPasswordException;
}
