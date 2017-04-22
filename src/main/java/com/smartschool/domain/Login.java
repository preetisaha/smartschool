package com.smartschool.domain;

public class Login {
	
	private String email;
	private String password;
	private int userId;
	
	public Login(String email, String password, int userId){
		this.email = email;
		this.password = password;
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}
	
	
}
