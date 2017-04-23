package com.smartschool.dto;

import java.util.List;

import com.smartschool.domain.Course;


public class AuthTeacher {

	private int teacherId;
	private String teacherName;
	private String designation;
	private String email;
	private List<Course> course;
	
	public AuthTeacher(int teacherId, String teacherName, String designation, String email, List<Course> course){
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.designation = designation;
		this.email = email;
		this.course = course;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEmail() {
		return email;
	}

	public List<Course> getCourse() {
		return course;
	}
	
	
}
