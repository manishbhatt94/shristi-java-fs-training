package com.list.examples;

public class Student implements Comparable<Student> {

	private String name;
	private int studentId;
	private String city;

	public Student() {
		super();
	}

	public Student(String name, int studentId, String city) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + ", city=" + city + "]";
	}

	@Override
	public int compareTo(Student student1) {
		int cityCompareVal = this.getCity().compareTo(student1.getCity());
		if (cityCompareVal == 0) {
			int nameCompareVal = this.getName().compareTo(student1.getName());
			return nameCompareVal;
		}
		return cityCompareVal;
	}

}
