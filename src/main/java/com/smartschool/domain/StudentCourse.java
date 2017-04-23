package com.smartschool.domain;

public class StudentCourse {

	private int studentId;
	private int student_course_id;
	
	public StudentCourse(int sid, int student_course_id){
		this.studentId = sid;
		this.student_course_id = student_course_id;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getStudent_course_id() {
		return student_course_id;
	}
	
	
}
