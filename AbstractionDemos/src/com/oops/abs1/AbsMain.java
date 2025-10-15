package com.oops.abs1;

public class AbsMain {

	public static void main(String[] args) {
		Bank bank = new Branch1();
		// using bank reference call all methods of bank
		bank.carLoan();
		bank.housingLoan();
		bank.eduLoan();
		bank.adminDetails();
		
		// own method of Branch1
		Branch1 branch1 = (Branch1) bank;
		branch1.depositTypes();
		
		// Branch2 is abstract - so can't instantiate it
		bank = new SubBranch();
		bank.carLoan();
		bank.housingLoan();
		bank.eduLoan();
		bank.adminDetails();
		
		SubBranch subBranch = (SubBranch) bank;
		subBranch.cardTypes(); // own method of SubBranch
		subBranch.loanTypes(); // own method of Branch2
		
		Branch2 branch2 = (Branch2) bank;
		branch2.loanTypes();
	}
}
