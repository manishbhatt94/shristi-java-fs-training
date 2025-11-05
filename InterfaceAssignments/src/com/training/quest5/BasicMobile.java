package com.training.quest5;

public class BasicMobile implements IFeaturePhone {

	@Override
	public void call() {
		System.out.println("Call using buttons");
	}

	@Override
	public void messaging() {
		System.out.println("SMS messaging service");
	}
}
