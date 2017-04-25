package com.smartschool.dto;

import java.util.ArrayList;
import java.util.List;

import com.smartschool.domain.Exam;

public class ExamStatus {
	private List<Exam> notPublish = new ArrayList<Exam>();
	private List<Exam> upcomingExam = new ArrayList<Exam>();
	private List<Exam> gradeExam = new ArrayList<Exam>();
	private List<Exam> editGrade = new ArrayList<Exam>();
	
	public List<Exam> getNotPublish() {
		return notPublish;
	}
	public List<Exam> getUpcomingExam() {
		return upcomingExam;
	}
	public List<Exam> getGradeExam() {
		return gradeExam;
	}
	public List<Exam> getEditGrade() {
		return editGrade;
	}

	

}
