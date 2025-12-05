package com.lang.examples;

public class Student implements Cloneable {

	private String studentName;
	private int studentId;
	private String city;

	public Student() {
		super();
	}

	public Student(String studentName, int studentId, String city) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.city = city;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("Cloning...");
		return super.clone();
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", city=" + city + "]";
	}

}
