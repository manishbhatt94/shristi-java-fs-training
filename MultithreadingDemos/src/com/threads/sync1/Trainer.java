package com.threads.sync1;

public class Trainer {

	private String trainerName;

	public Trainer(String trainerName) {
		super();
		this.trainerName = trainerName;
	}

	String askDoubts(String studentName, String question) {
		System.out.println("Student Name: " + studentName);
		System.out.println("Question: " + question);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String answer = question + " answered for you!";
		System.out.println("Answer: " + answer);
		return answer;
	}
}
