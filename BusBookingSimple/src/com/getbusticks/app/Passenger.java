package com.getbusticks.app;

public class Passenger {

	private int passengerId;
	private String name;
	private int age;
	private String gender;

	private static int nextPassengerId = 701;

	public Passenger(String name, int age, String gender) {
		super();
		this.passengerId = nextPassengerId++;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return getPassengerInfo();
	}

	public String getPassengerInfo() {
		return String.format("Passenger: %s (%d %s)", name, age, gender);
	}
}
