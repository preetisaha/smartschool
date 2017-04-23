package com.smartschool.dto;

import java.util.List;

import com.smartschool.domain.Course;

public class AuthStudent {

	private int studentId;
	private String studentName;
	private String email;
	private List<Course> course;
	
	public AuthStudent(int studentId, String studentName, String email, List<Course> course){
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.course = course;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getEmail() {
		return email;
	}

	public List<Course> getCourse() {
		return course;
	}
	
}
