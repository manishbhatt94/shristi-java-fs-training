package com.training.basic;

public class Perfect {

	public static void main(String[] args) {
		int num = 6;
		System.out.println("Number: " + num);

		Perfect obj = new Perfect();

		if (obj.isPerfect(num)) {
			System.out.println("Number " + num + " is a Perfect number!");
		} else {
			System.out.println("Number " + num + " is not a Perfect number!");
		}
	}

	private boolean isPerfect(int num) {
		int sumFactors = 1; //

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				sumFactors += i;
			}
		}

		return sumFactors == num;
	}
}
