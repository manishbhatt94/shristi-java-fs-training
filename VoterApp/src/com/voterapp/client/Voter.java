package com.voterapp.client;

import java.util.Scanner;

import com.voterapp.exception.InvalidVoterIDException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NotEligibleException;
import com.voterapp.exception.UnderAgeException;
import com.voterapp.service.ElectionBoothServiceImpl;
import com.voterapp.service.IElectionBoothService;

public class Voter {

	public static void main(String[] args) {

		System.out.println("Welcome to Bengaluru South Central - Corporation Elections 2025");
		System.out.println("Voters, please enter your age, locality, and voter ID numbers\n"
				+ "one by one (as prompted) to check if you're eligible to vote in this election");
		IElectionBoothService boothService = new ElectionBoothServiceImpl();
		boolean eligible = false;

		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\nEnter voter's age:");
			int age = sc.nextInt();
			System.out.println("Received voter age: " + age);

			// Consume the leftover newline character
			sc.nextLine();

			System.out.println("\nEnter voter's locality:");
			String locality = sc.nextLine();
			System.out.println("Received voter locality: " + locality);

			System.out.println("\nEnter voter's voterId number:");
			int voterId = sc.nextInt();
			System.out.println("Received voter ID number: " + voterId);

			System.out.println("\nChecking if this voter is eligible to vote...");
			try {
				eligible = boothService.checkEligibility(age, locality, voterId);
			} catch (UnderAgeException e) {
				System.out.println(
						"checkEligibility call failed - issue with voter age - error message: " + e.getMessage());
			} catch (LocalityNotFoundException e) {
				System.out.println(
						"checkEligibility call failed - issue with voter locality - error message: " + e.getMessage());
			} catch (InvalidVoterIDException e) {
				System.out.println(
						"checkEligibility call failed - issue with voter ID - error message: " + e.getMessage());
			} catch (NotEligibleException e) {
				System.out.println("checkEligibility call failed - unknown issue with voter info - error message: "
						+ e.getMessage());
			}
		}

		if (eligible) {
			System.out.println("\n✅ This voter IS ELIGIBLE to vote in the upcoming elections!");
		} else {
			System.out.println("\n❌ This voter IS NOT ELIGIBLE to vote in the upcoming elections!");
		}
	}
}
