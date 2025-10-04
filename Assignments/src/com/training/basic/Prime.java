package com.training.basic;

import java.util.Arrays;

public class Prime {

	public static void main(String[] args) {
		int num = 100;

		System.out.println("Primes till " + num + ":");

		Prime obj = new Prime();
		boolean[] primes = obj.getSieve(num);

		for (int i = 2; i <= num; i++) {
			if (primes[i]) {
				System.out.print(i + " ");
			}
		}

		System.out.println();
	}

	private boolean[] getSieve(int num) {
		boolean[] prime = new boolean[num + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i * i <= num; i++) {
			if (prime[i] == false) {
				continue;
			}
			for (int k = i * i; k <= num; k += i) {
				prime[k] = false;
			}
		}

		return prime;
	}
}
