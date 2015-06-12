package com.infonal.user.model;

public class User {

	private String userId;
	private String name;
	private String surName;
	private Integer phoneNumber;

	public User() {
	}

	public User(String name, String surName, Integer phoneNumber, String userId) {
		this.userId = userId;
		this.name = name;
		this.surName = surName;
		this.phoneNumber = phoneNumber;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
