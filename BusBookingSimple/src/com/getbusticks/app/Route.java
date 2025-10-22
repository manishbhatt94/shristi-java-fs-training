package com.getbusticks.app;

public class Route {

	private int routeId;
	private String source;
	private String destination;
	private double distanceKm;

	private static int nextRouteId = 5001;

	public Route(String source, String destination, double distanceKm) {
		super();
		this.routeId = nextRouteId++;
		this.source = source;
		this.destination = destination;
		this.distanceKm = distanceKm;
	}

	public int getRouteId() {
		return routeId;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	@Override
	public String toString() {
		return getRouteInfo();
	}

	// Bengaluru → Chennai (350 km)
	public String getRouteInfo() {
		return String.format("%s → %s (%.2f km)", source, destination, distanceKm);
	}
}
