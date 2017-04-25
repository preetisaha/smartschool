package com.smartschool.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.ExamDAO;
import com.smartschool.domain.Exam;
import com.smartschool.dto.ExamStatus;

@Service
public class ExamService {

	@Autowired
	ExamDAO examDAO;

	public Exam createExam(String examName, int courseId) {
		Exam exam = examDAO.createExam(examName, courseId);
		return exam;
	}

	public ExamStatus getExamStatus(int courseId) {

		ExamStatus examStatus = new ExamStatus();
		List<Exam> exams = examDAO.getExamList(courseId);

		Date currentDate = new Date();

		for (int count = 0; count < exams.size(); count++) {
			Exam eachExam = exams.get(count);

			if (eachExam.getPublish() == false) {
				examStatus.getNotPublish().add(eachExam);
			} 
			
			else if (eachExam.getPublish() == true && eachExam.getEndDate().compareTo(currentDate) > 0) {
				examStatus.getUpcomingExam().add(eachExam);
			} 
			
			else if (eachExam.getPublish() == true && eachExam.getEndDate().compareTo(currentDate) < 0
					&& eachExam.getGradeStatus() == false) {
				examStatus.getGradeExam().add(eachExam);
			} 
			
			else if (eachExam.getPublish() == true && eachExam.getEndDate().compareTo(currentDate) < 0
					&& eachExam.getGradeStatus() == true) {
				examStatus.getEditGrade().add(eachExam);
			}

		}
		return examStatus;

	}
}
