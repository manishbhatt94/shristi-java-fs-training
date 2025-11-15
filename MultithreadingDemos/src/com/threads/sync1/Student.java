package com.threads.sync1;

public class Student implements Runnable {

	private String studentName;
	private String question;
	private Trainer trainer;

	public Student(String studentName, String question, Trainer trainer) {
		super();
		this.studentName = studentName;
		this.question = question;
		this.trainer = trainer;
		Thread thread = new Thread(this, studentName);
		thread.start();
	}

	@Override
	public void run() {
		String result = trainer.askDoubts(studentName, question);
		System.out.println("Answer received by student thread: " + result);
		System.out.println("Doubts cleared");
	}

	public static void main(String[] args) {
		Trainer trainer = new Trainer("SriPriya");
		Student student1 = new Student("Raju", "What is a thread?", trainer);
		Student student2 = new Student("Rakesh", "What is a overriding?", trainer);
		Student student3 = new Student("Rahul", "What is a Java?", trainer);
	}

}
