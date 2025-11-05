package com.training.quest5;

public interface IFeaturePhone {

	void call();

	void messaging();

	default void playGames() {
		System.out.println("Play games on feature phone - Space Impact, Snake 2, Soltaire");
	}

	static void brandInfo() {
		System.out.println("Feature phone - brand related generic information");
	}
}
