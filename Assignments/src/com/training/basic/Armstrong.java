package com.training.basic;

public class Armstrong {

	public static void main(String[] args) {
		int num = 153; // is an Armstrong number? ✅
//		int num = 9474;		// is an Armstrong number? ✅
//		int num = 123;		// is an Armstrong number? ❌
		Armstrong obj = new Armstrong();
		System.out.println(obj.isArmstrong(num));
	}

	private boolean isArmstrong(int num) {
		int numDigits = num > 0 ? (int) Math.floor(Math.log10((double) num)) + 1 : 1;
		long digitPowerSum = 0L;

		int n = num;

		while (n > 0) {
			int digit = n % 10;
			digitPowerSum += Math.pow(digit, numDigits);
			n = n / 10;
		}

		return digitPowerSum == num;
	}
}
