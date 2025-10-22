package com.getbusticks.app;

import java.util.ArrayList;
import java.util.List;

public class SeedData {

	public static ArrayList<Route> createRoutes() {
		ArrayList<Route> routes = new ArrayList<>();
		routes.add(new Route("Bengaluru", "Chennai", 350));
		routes.add(new Route("Bengaluru", "Hyderabad", 580));
		routes.add(new Route("Chennai", "Coimbatore", 510));
		routes.add(new Route("Delhi", "Jaipur", 280));
		routes.add(new Route("Mumbai", "Pune", 150));
		return routes;
	}

	public static ArrayList<Bus> createBuses(List<Route> routes) {
		ArrayList<Bus> buses = new ArrayList<>();

		// Route 1: Bengaluru -> Chennai
		buses.add(new NonAcBus(routes.get(0), 40, 2, 2.5, false));
		buses.add(new AcBus(routes.get(0), 40, 1, 3.0, true, true));

		// Route 2: Bengaluru -> Hyderabad
		buses.add(new AcBus(routes.get(1), 35, 3, 3.2, false, true));
		buses.add(new LuxuryBus(routes.get(1), 30, 2, 3.5, true, true));

		// Route 3: Chennai -> Coimbatore
		buses.add(new NonAcBus(routes.get(2), 45, 1, 2.0, true));
		buses.add(new LuxuryBus(routes.get(2), 25, 4, 3.6, false, true));

		// Route 4: Delhi -> Jaipur
		buses.add(new AcBus(routes.get(3), 40, 2, 3.0, true, false));
		buses.add(new NonAcBus(routes.get(3), 50, 0, 2.2, false));

		// Route 5: Mumbai -> Pune
		buses.add(new LuxuryBus(routes.get(4), 28, 2, 3.8, true, false));
		buses.add(new AcBus(routes.get(4), 36, 2, 3.1, false, true));

		return buses;
	}
}
