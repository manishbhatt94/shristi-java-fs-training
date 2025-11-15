package com.threads.sync1;

public class TrainingRoom implements Runnable {

	private String studentName;
	private String question;
	private Thread thread;

	public TrainingRoom(String studentName, String question) {
		super();
		this.studentName = studentName;
		this.question = question;
		this.thread = new Thread(this, studentName);
		this.thread.start();
	}

	@Override
	public void run() {
		System.out.println("Great day - " + Thread.currentThread().getName());
		Trainer trainer = new Trainer("SriPriya");
		System.out.println("Thread: Answer = " + trainer.askDoubts(null, null));
		System.out.println("Doubts cleared.");
	}

}
