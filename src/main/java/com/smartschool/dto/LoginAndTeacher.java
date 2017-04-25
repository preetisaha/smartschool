package com.smartschool.dto;

public class LoginAndTeacher {
	
	private String teacherName;
	private String email;
	private String designation;
	
	public LoginAndTeacher(String teacherName, String email, String designation){
		this.teacherName = teacherName;
		this.email = email;
		this.designation = designation;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getEmail() {
		return email;
	}

	public String getDesignation() {
		return designation;
	}
	
	
}
