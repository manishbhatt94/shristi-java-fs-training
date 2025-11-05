package com.training.quest5;

public interface ISmartPhone extends IFeaturePhone {

	String[] showApps();

	void useCamera();

	void payBills(String type);

	default void downloadMusic() {
		System.out.println("ISmartPhone functionality - downloading music");
	}

	static void brandInfo() {
		System.out.println("Smart phone - brand related generic information");
	}
}
