package com.smartschool.domain;

public class Question {

	private int questionId;
	private String question;
	private int marks;
	private boolean multipleChoice;
	private int examId;
	
	public Question(int questionId, String question, int marks, boolean multipleChoice, int examId){
		this.questionId = questionId;
		this.question = question;
		this.marks = marks;
		this.multipleChoice = multipleChoice;
		this.examId = examId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public String getQuestion() {
		return question;
	}

	public int getMarks() {
		return marks;
	}

	public int getExamId() {
		return examId;
	}

	public boolean isMultipleChoice() {
		return multipleChoice;
	}
	
	
}
