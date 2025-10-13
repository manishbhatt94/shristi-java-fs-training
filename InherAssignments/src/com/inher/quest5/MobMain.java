package com.inher.quest5;

import java.util.Arrays;

public class MobMain {

	public static void main(String[] args) {
		Mobile mobile1 = new FeaturePhone();
		mobile1.call();

		System.out.println();

		Mobile mobile2 = new SmartPhone();
		mobile2.call();
		System.out.println("Apps installed on the SmartPhone:");
		String[] installedApps = ((SmartPhone) mobile2).apps();
		System.out.println(Arrays.toString(installedApps));
	}
}
