package com.getbusticks.app;

public class AcBus extends Bus {

	private boolean wifiAvailable;

	private static final double WIFI_CHARGE = 50.0;
	private static final double SEATER_MULTIPLIER = 1.25;
	private static final double SLEEPER_MULTIPLIER = 1.35;

	public AcBus(Route route, int totalSeats, int availableSeats, double baseFarePerKm, boolean sleeper,
			boolean wifiAvailable) {
		super(route, totalSeats, availableSeats, baseFarePerKm, sleeper);
		this.wifiAvailable = wifiAvailable;
	}

	@Override
	public String getBusType() {
		return "AC " + getSeatingInfo() + " Bus";
	}

	@Override
	public double calculateFare() {
		double multiplier = isSleeper() ? SLEEPER_MULTIPLIER : SEATER_MULTIPLIER;
		double fare = getBaseFarePerKm() * getRoute().getDistanceKm() * multiplier;
		if (wifiAvailable) {
			fare += WIFI_CHARGE;
		}
		return fare;
	}

	@Override
	public String getBusInfo() {
		String basicInfo = super.getBusInfo();
		String type = getBusType();
		String fare = String.format("Fare: ₹%.2f", calculateFare());
		String info = String.format("%s | %s | %s", basicInfo, type, fare);
		if (wifiAvailable) {
			info += " | Includes Wifi";
		}
		return info;
	}
}
