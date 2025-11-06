package com.funcinter.quest4;

public class GamesMain {

	public static void main(String[] args) {
		System.out.println("Indoor / Outdoor games facilities at City Centre Stadium:\n\n");

		IGames games = null;

		// indoor games
		games = () -> System.out.println("Indoor games: Carrom, Table Tennis, Chess, Foosball.\n");
		games.showGames();

		// outdoor games
		games = () -> System.out.println("Outdoor games: Cricket, Football, Basketball, Volleyball");
		games.showGames();
	}
}
