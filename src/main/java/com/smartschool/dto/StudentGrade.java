package com.smartschool.dto;

public class StudentGrade {

	private String examName;
	private int grade;
	
	public StudentGrade(String examName, int grade) {
		this.examName = examName;
		this.grade = grade;
	}

	public String getExamName() {
		return examName;
	}

	public int getGrade() {
		return grade;
	}
	
	
}
