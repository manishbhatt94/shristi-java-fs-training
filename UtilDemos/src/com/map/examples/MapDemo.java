package com.map.examples;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {

		// HashMap - entries added by hash-code value of keys.
		// Accepts a null valued key.
		// Map<Integer, String> map = new HashMap<>();

		// LinkedHashMap - retains insertion order of entries.
		// Accepts a null valued key.
		// Map<Integer, String> map = new LinkedHashMap<>();

		// TreeMap - sorts entries by their key.
		// Does NOT allow null value as key (coz it can't be compared for sorting of
		// entries by key).
		Map<Integer, String> map = new TreeMap<>();

		map.put(45, "Java");
		map.put(20, "CSS");
		map.put(82, "Spring");
		// null as key - Not allowed in TreeMap. Allowed in HashMap & LinkedHashMap.
		// map.put(null, "HTML");
		map.put(1, "Java");
		map.put(82, "Microservices");
		// null as key - Not allowed in TreeMap. Allowed in HashMap & LinkedHashMap.
		// Updates the value of entry with 'null' as the key:
		// map.put(null, "Microservices");

		System.out.println("Printing the map:");
		System.out.println(map);
		System.out.println();

		System.out.println("Trying some methods on map:");
		System.out.println("map.get(20).toLowerCase() = " + map.get(20).toLowerCase()); // css
		System.out.println("map.get(11) = " + map.get(11)); // null -- no such key present in the map
		System.out.println("map.containsKey(11) = " + map.containsKey(11)); // false
		System.out.println("map.containsValue(\"Java\") = " + map.containsValue("Java"));
		System.out.println("map.getOrDefault(11, \"not available\") = " + map.getOrDefault(11, "not available"));
		System.out.println();

		// returns the keys
		System.out.println("Checking map.keySet()");
		Set<Integer> keys = map.keySet();
		System.out.println("keys = " + keys);
		System.out.println();

		// iterate using keySet
		System.out.println("Iterating on the map using keySet");
		for (Integer key : keys) {
			System.out.println(key + " " + map.get(key));
		}
		System.out.println();

		// iterate using entrySet
		System.out.println("Iterating on the map using entrySet");
		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println();

		// returns the values
		System.out.println("Checking map.values()");
		Collection<String> values = map.values(); // get the values
		System.out.println("values = " + values);
		System.out.println();

	}

}
