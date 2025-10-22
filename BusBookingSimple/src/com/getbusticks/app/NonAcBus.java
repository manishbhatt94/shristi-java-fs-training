package com.getbusticks.app;

public class NonAcBus extends Bus {

	public NonAcBus(Route route, int totalSeats, int availableSeats, double baseFarePerKm, boolean sleeper) {
		super(route, totalSeats, availableSeats, baseFarePerKm, sleeper);
	}

	@Override
	public String getBusType() {
		return "Non-AC " + getSeatingInfo() + " Bus";
	}

	@Override
	public double calculateFare() {
		double multiplier = isSleeper() ? 1.05 : 1.0;
		double fare = getBaseFarePerKm() * getRoute().getDistanceKm() * multiplier;
		return fare;
	}

	@Override
	public String getBusInfo() {
		String basicInfo = super.getBusInfo();
		String type = getBusType();
		String fare = String.format("Fare: ₹%.2f", calculateFare());
		String info = String.format("%s | %s | %s", basicInfo, type, fare);
		return info;
	}
}
