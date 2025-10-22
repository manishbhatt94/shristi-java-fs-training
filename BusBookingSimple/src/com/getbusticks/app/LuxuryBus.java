package com.getbusticks.app;

public class LuxuryBus extends Bus {

	private boolean mealIncluded;

	private static final double MEAL_CHARGE = 150.0;
	private static final double SEATER_MULTIPLIER = 1.5;
	private static final double SLEEPER_MULTIPLIER = 1.6;

	public LuxuryBus(Route route, int totalSeats, int availableSeats, double baseFarePerKm, boolean sleeper,
			boolean mealIncluded) {
		super(route, totalSeats, availableSeats, baseFarePerKm, sleeper);
		this.mealIncluded = mealIncluded;
	}

	@Override
	public String toString() {
		return getBusInfo();
	}

	@Override
	public String getBusType() {
		return "Luxury " + getSeatingInfo() + " Bus";
	}

	@Override
	public double calculateFare() {
		double multiplier = isSleeper() ? SLEEPER_MULTIPLIER : SEATER_MULTIPLIER;
		double fare = getBaseFarePerKm() * getRoute().getDistanceKm() * multiplier;
		if (mealIncluded) {
			fare += MEAL_CHARGE;
		}
		return fare;
	}

	@Override
	public String getBusInfo() {
		String basicInfo = super.getBusInfo();
		String type = getBusType();
		String fare = String.format("Fare: ₹%.2f", calculateFare());
		String info = String.format("%s | %s | %s", basicInfo, type, fare);
		if (mealIncluded) {
			info += " | Includes meal";
		}
		return info;
	}
}
