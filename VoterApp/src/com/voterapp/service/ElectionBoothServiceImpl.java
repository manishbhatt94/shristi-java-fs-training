package com.voterapp.service;

import com.voterapp.exception.InvalidVoterIDException;
import com.voterapp.exception.LocalityNotFoundException;
import com.voterapp.exception.NotEligibleException;
import com.voterapp.exception.UnderAgeException;

public class ElectionBoothServiceImpl implements IElectionBoothService {

	@Override
	public boolean checkEligibility(int age, String locality, int vid) throws NotEligibleException {
		try {
			checkAge(age);
			checkLocality(locality);
			checkVoterId(vid);
			return true;
		} catch (NotEligibleException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private boolean checkAge(int age) throws UnderAgeException {
		if (age < 18) {
			throw new UnderAgeException(
					String.format("Must be at least 18 years old to vote. Provided age: %d is not eligible.", age));
		}
		return true;
	}

	private boolean checkLocality(String locality) throws LocalityNotFoundException {
		String[] localities = { "Jayanagara", "Banashankari", "Basavanagudi", "Hanumanthanagara", "Malleshwaram" };
		for (String validLocality : localities) {
			if (locality.equalsIgnoreCase(validLocality)) {
				return true;
			}
		}
		throw new LocalityNotFoundException(String.format("Locality: '%s' is not valid.", locality));
	}

	private boolean checkVoterId(int voterId) throws InvalidVoterIDException {
		if (voterId < 1000 || voterId > 9999) {
			throw new InvalidVoterIDException(String.format("Voter ID number: %d is not valid.", voterId));
		}
		return true;
	}

}
