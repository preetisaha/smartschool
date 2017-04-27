package com.smartschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.domain.Grade;
import com.smartschool.dto.StudentGrade;
import com.smartschool.service.GradeService;

@Controller
public class GradeController {

	@Autowired
	GradeService gradeService;
	
	@RequestMapping(value = "/editFinalGrades", method = RequestMethod.GET)
	public ModelAndView editExamGrades(@RequestParam int teacherId, @RequestParam int courseId, @RequestParam int examId) {
		ModelAndView mav = new ModelAndView();
		List<Grade> gradeList = gradeService.getGradesByExam(examId);
		
		mav.addObject("gradeList", gradeList);
		mav.addObject("teacherId", teacherId);
		mav.addObject("courseId", courseId);
		mav.addObject("examId", examId);
		
		mav.setViewName("editGrades");
		return mav;
	}
	
	@RequestMapping(value="/updateGrade", method = RequestMethod.GET)
	public ModelAndView updateGrade(@RequestParam int teacherId, 
			@RequestParam int studentId, 
			@RequestParam int courseId, 
			@RequestParam int examId,
			@RequestParam int grade) {
		gradeService.overRideGrade(studentId, examId, courseId, grade);
		
		ModelAndView mav = new ModelAndView();
		List<Grade> gradeList = gradeService.getGradesByExam(examId);
		
		mav.addObject("gradeList", gradeList);
		mav.addObject("teacherId", teacherId);
		mav.addObject("courseId", courseId);
		mav.addObject("examId", examId);
		
		mav.setViewName("editGrades");
		return mav;
	}
	
	@RequestMapping(value="/viewGrades", method = RequestMethod.GET)
	public ModelAndView getStudentGrades(@RequestParam int studentId, @RequestParam int courseId) {
		ModelAndView mav = new ModelAndView();
		List<StudentGrade> gradeList = gradeService.getStudentGrades(studentId, courseId);
		mav.addObject("gradeList", gradeList);
		mav.setViewName("viewStudentGrades");
		return mav;
	}
}
