package com.io.serial;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2L;
	private String userName;
	private transient int userId;
	private String city;

	public User() {
		super();
	}

	public User(String userName, int userId, String city) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", city=" + city + "]";
	}

}
