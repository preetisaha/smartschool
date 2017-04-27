package com.smartschool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.ExamDAO;
import com.smartschool.DAO.GradeDAO;
import com.smartschool.domain.Exam;
import com.smartschool.domain.Grade;
import com.smartschool.dto.StudentGrade;

@Service
public class GradeService {

	@Autowired
	GradeDAO gradeDAO;
	
	@Autowired
	ExamDAO examDAO;
	
	public List<Grade> getGradesByExam(int examId) {
		return gradeDAO.getGradesByExam(examId);
	}
	
	public void overRideGrade(int studentId, int examId, int courseId, int grade) {
		gradeDAO.overRideGrade(studentId, examId, courseId, grade);
	}
	
	public List<StudentGrade> getStudentGrades(int studentId, int courseId) {
		List<StudentGrade> studentGrades = new ArrayList<>();
		List<Grade> grades = gradeDAO.getStudentGrades(studentId, courseId);
		
		for (Grade grade : grades) {
			Exam exam = examDAO.getExam(grade.getId_exam());
			studentGrades.add(new StudentGrade(exam.getExamName(), grade.getGrade()));
		}
		
		return studentGrades;
	}
}
