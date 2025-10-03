package com.shrishti.training;

public class IfElse {

	public static void main(String[] args) {
		String name = "Eminem";
		if (name.equals("Eminem")) {
			System.out.println("Welcome: " + name);
		} else {
			System.out.println("Wrong username: " + name);
		}
		
		// greater of 3 numbers
		int num1 = 100;
		int num2 = 90;
		int num3 = 130;
		
		if (num1 > num2 && num1 > num3) {
			System.out.println(num1 + " is the greater of the numbers");
		}
		if (num2 > num1 && num2 > num3) {
			System.out.println(num2 + " is the greater of the numbers");
		}
		if (num3 > num1 && num3 > num2) {
			System.out.println(num3 + " is the greater of the numbers");
		}
	}

}
