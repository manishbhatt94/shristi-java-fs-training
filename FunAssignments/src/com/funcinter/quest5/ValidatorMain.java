package com.funcinter.quest5;

public class ValidatorMain {

	public static void main(String[] args) {
		String[] registeredUsers = { "TomHanks", "therock", "SamuelLJackson", "KevinSpacey" };

		IValidator registerValidator = (name) -> {
			for (String regUser : registeredUsers) {
				if (name.equalsIgnoreCase(regUser)) {
					// registration failed - username already taken
					return String.format(
							"❌ Registration failed! \"%s\" username is already taken. Try again & pick a different username!",
							name);
				}
			}
			return String.format("✅ Registration success! You are now registered \"%s\".", name);
		};
		System.out.println(registerValidator.validateUser("therock"));
		System.out.println(registerValidator.validateUser("TomCruise"));

		System.out.println();

		IValidator loginValidator = (name) -> {
			for (String regUser : registeredUsers) {
				if (name.equalsIgnoreCase(regUser)) {
					// login success - username found amongst registered users
					return String.format("✅ Login success! You are now logged in \"%s\".", name);
				}
			}
			return String.format("❌ Login failed! \"%s\" username is not registered!", name);
		};
		System.out.println(loginValidator.validateUser("steve.carell"));
		System.out.println(loginValidator.validateUser("kevinSpacey"));
	}
}
