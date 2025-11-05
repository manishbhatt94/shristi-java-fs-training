package com.training.quest5;

public class TouchScreenMobile extends BasicMobile implements ISmartPhone {

	@Override
	public String[] showApps() {
		return new String[] { "WhatsApp", "Weather", "UPI App", "YouTube" };
	}

	@Override
	public void useCamera() {
		System.out.println("Using camera on touch screen mobile");
	}

	@Override
	public void payBills(String type) {
		System.out.println("Using touch screen mobile to pay bill for " + type);
	}

	@Override
	public void downloadMusic() {
		ISmartPhone.super.downloadMusic();
		System.out.println("TouchScreen specific - downloading music");
	}

	@Override
	public void playGames() {
		System.out.println("Play games on touchscreen phone - Candy Crush, Subway Surfer, PubG");
	}
}
