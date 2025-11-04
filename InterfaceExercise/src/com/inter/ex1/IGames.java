package com.inter.ex1;

public interface IGames {

	String[] indoor();

	String[] outdoor();

	default void playTournaments() {
		System.out.println("Intra organization cricket tournaments");
	}
}
