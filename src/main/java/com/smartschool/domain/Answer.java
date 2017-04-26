package com.smartschool.domain;

public class Answer {

	private int answerId;
	private int question_id;
	private String answer;
	private int student_id;
	private int marks;
	
	public Answer(int answerId, int question_id, String answer, int student_id, int marks) {
		this.answerId = answerId;
		this.question_id = question_id;
		this.answer = answer;
		this.student_id = student_id;
		this.marks = marks;
	}

	public int getAnswerId() {
		return answerId;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public int getStudent_id() {
		return student_id;
	}

	public int getMarks() {
		return marks;
	}
	
	
}
