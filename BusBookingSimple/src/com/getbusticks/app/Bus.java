package com.getbusticks.app;

public abstract class Bus {

	private int busId;
	private Route route;
	private int totalSeats;
	private int availableSeats;
	private double baseFarePerKm; // base fare per kilometer for this bus type
	private boolean sleeper;

	private static int nextBusId = 301;

	public Bus(Route route, int totalSeats, int availableSeats, double baseFarePerKm, boolean sleeper) {
		super();
		this.busId = nextBusId++;
		this.route = route;
		this.totalSeats = totalSeats;
		this.availableSeats = availableSeats;
		this.baseFarePerKm = baseFarePerKm;
		this.sleeper = sleeper;
	}

	public abstract String getBusType();

	public abstract double calculateFare();

	@Override
	public String toString() {
	    return getBusInfo() + " | Type: " + getBusType();
	}

	public double getBaseFarePerKm() {
		return baseFarePerKm;
	}

	public Route getRoute() {
		return route;
	}

	public boolean isSleeper() {
		return sleeper;
	}

	public String getSeatingInfo() {
		return sleeper ? "Sleeper" : "Seater";
	}

	public String getBusInfo() {
		String routeInfo = route.getRouteInfo();
		return String.format("Bus ID: %d | Route: %s | Seats Available: %d", busId, routeInfo, availableSeats);
	}

	public boolean bookSeat() {
		if (availableSeats > 0) {
			availableSeats -= 1;
			return true;
		}
		return false;
	}
}
