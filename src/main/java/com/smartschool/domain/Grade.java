package com.smartschool.domain;


public class Grade {

	private int id_student;
	private int id_exam;
	private int id_course;
	private int grade;
	
	public Grade(int id_student, int id_exam, int id_course, int grade){
		this.id_student = id_student;
		this.id_exam = id_exam;
		this.id_course = id_course;
		this.grade = grade;
	}

	public int getId_student() {
		return id_student;
	}

	public int getId_exam() {
		return id_exam;
	}

	public int getId_course() {
		return id_course;
	}

	public int getGrade() {
		return grade;
	}
	
	
}
