package com.smartschool.domain;

import java.util.Date;

public class Exam {

	private int examId;
	private String examName;
	private Date startDate;
	private Date endDate;
	private int courseId;
	private boolean publish;
	private boolean grade_status;
	
	public Exam(int examId, String examName, Date startDate, Date endDate, int courseId, boolean publish, boolean grade_status){
		this.examId = examId;
		this.examName = examName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade_status = grade_status;
		this.courseId = courseId;
		this.publish = publish;
	}

	public int getExamId() {
		return examId;
	}

	public String getExamName() {
		return examName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public boolean getPublish() {
		return publish;
	}

	public boolean getGradeStatus() {
		return grade_status;
	}

	public int getCourseId() {
		return courseId;
	}
}
