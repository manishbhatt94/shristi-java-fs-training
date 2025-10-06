package com.training.scan;

import java.util.Arrays;
import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] usernames = { "manishb94", "rcbtv", "drdre", "djquik", "icecube" };
		System.out.println(Arrays.toString(usernames));

		System.out.print("Enter name to register: ");
		String newUser = sc.next();

		// check if user-name is already taken
		boolean isUnameTaken = false;

		for (String uname : usernames) {
			if (newUser.equals(uname)) {
				isUnameTaken = true;
				break;
			}
		}

		if (isUnameTaken) {
			System.out.println("Name is not unique");
		} else {
			System.out.println("You are registered");
		}

		sc.close();
	}
}
