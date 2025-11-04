package com.inter.ex1;

import java.util.Arrays;

public class CompanyDetails {

	public static void main(String[] args) {
		// super class ref = sub class object
		Employee employee = new Manager("Kevin", 10, "Bengaluru", "Marketing");
		employee.printDetails(); // from Employee
		employee.calcBonus(2000); // from Manager
		employee.projectDetails(); // from Manager

		employee.showPolicyDetails(); // from IInsurance
		employee.showActivities(); // from IActivityClubs

		// interface ref = implementation class object
		IInsurance insurance = employee;
		insurance.showPolicyDetails();
		IInsurance.policyProvider();

		IActivityClubs activityClubs = employee;
		activityClubs.showActivities();

		// This is for developer - can't create an object of TeamLeader
		employee = new Developer("Kumaran", 20, "Chennai", 1800, "kuma.ran@amz.co");
		employee.printDetails(); // from Employee
		employee.calcBonus(1200); // from Developer
		employee.projectDetails(); // from TeamLeader
		employee.showActivities(); // from Developer

		TeamLeader devLead = (TeamLeader) employee;
		devLead.indoor(); // from Developer
		devLead.outdoor(); // from Developer
		String[] certifications = devLead.mandateCertifications(); // own method of TeamLeader
		System.out.println(Arrays.toString(certifications));
	}
}
