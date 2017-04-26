package com.smartschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.GradeDAO;
import com.smartschool.domain.Grade;

@Service
public class GradeService {

	@Autowired
	GradeDAO gradeDAO;
	
	public List<Grade> getGradesByExam(int examId) {
		return gradeDAO.getGradesByExam(examId);
	}
	
	public void overRideGrade(int studentId, int examId, int courseId, int grade) {
		gradeDAO.overRideGrade(studentId, examId, courseId, grade);
	}
}
