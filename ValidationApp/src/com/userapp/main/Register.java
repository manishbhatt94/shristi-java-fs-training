package com.userapp.main;

import java.util.Scanner;

import com.userapp.exception.TooLongPasswordException;
import com.userapp.exception.TooShortPasswordException;
import com.userapp.exception.UsernameAlreadyExistsException;
import com.userapp.service.IValidatorService;
import com.userapp.service.ValidatorServiceImpl;

public class Register {

	public static void main(String[] args) {
		System.out.println("Welcome to JavaChat - Sign up page");

		IValidatorService validatorService = new ValidatorServiceImpl();

		String username;
		String password;

		System.out.println("\nChoose a username:");

		try (Scanner scanner = new Scanner(System.in);) {
			username = scanner.nextLine();
			if (validatorService.validateUsername(username)) {
				System.out.println("\nEnter a password:");
				password = scanner.nextLine();
				if (validatorService.validatePassword(password)) {
					System.out.println("\nYou have been registered on JavaChat - Have fun!");
				}
			}
		} catch (UsernameAlreadyExistsException e) {
			System.out.println("Issue with username: " + e.getMessage());
			e.printStackTrace();
		} catch (TooShortPasswordException | TooLongPasswordException e) {
			System.out.println("Issue with password: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
