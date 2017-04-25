package com.smartschool.domain;

public class Choice {
	private int multipleChoiceId;
	private boolean isValid;
	private String choice;
	private int questionId;
	
	public Choice(int multipleChoiceId, boolean isValid, String choice, int questionId) {
		this.choice = choice;
		this.isValid = isValid;
		this.questionId = questionId;
		this.multipleChoiceId = multipleChoiceId;
	}

	public int getMultipleChoiceId() {
		return multipleChoiceId;
	}

	public boolean isValid() {
		return isValid;
	}

	public String getChoice() {
		return choice;
	}

	public int getQuestionId() {
		return questionId;
	}
	
}
