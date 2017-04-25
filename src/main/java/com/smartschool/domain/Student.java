package com.smartschool.domain;

public class Student {
	
	private int studentId;
	private String studentName;
	private String email;

	public Student(int studentId, String studentName, String email){
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}
	
}
