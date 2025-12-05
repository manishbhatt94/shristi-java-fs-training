package com.training.quest1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {

		Map<String, List<String>> stateCities = new HashMap<>();

		stateCities.put("Karnataka", List.of("Mangaluru", "Mysuru", "Bengaluru", "Dharwad"));
		stateCities.put("Kerela", List.of("Thiruvananthapuram", "Kochi", "Kozhikode", "Thrissur"));
		stateCities.put("Tamil Nadu", List.of("Chennai", "Coimbatore", "Madurai", "Tiruchirappalli"));
		stateCities.put("Telangana", List.of("Hyderabad", "Warangal", "Karimnagar", "Nizamabad"));
		stateCities.put("Andhra Pradesh", List.of("Amravati", "Visakhapatnam", "Vijayawada", "Tirupati"));

		for (Map.Entry<String, List<String>> entry : stateCities.entrySet()) {
			System.out.println("Cities in State: " + entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
		}
	}
}
