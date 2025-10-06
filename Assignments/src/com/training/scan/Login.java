package com.training.scan;

import java.util.Arrays;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] registeredUsers = { "manishb94", "rcbtv", "drdre", "djquik", "icecube" };
		System.out.println(Arrays.toString(registeredUsers));

		System.out.print("Enter username to login: ");
		String loginUser = sc.next();

		// check if user-name is already taken
		boolean doesUserExist = false;

		for (String uname : registeredUsers) {
			if (loginUser.equals(uname)) {
				doesUserExist = true;
				break;
			}
		}

		if (doesUserExist) {
			System.out.println("You are logged in successfully");
		} else {
			System.out.println("Invalid username");
		}

		sc.close();
	}
}
