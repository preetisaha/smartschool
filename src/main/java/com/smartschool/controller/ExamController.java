package com.smartschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.domain.Exam;
import com.smartschool.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	ExamService examService;
	
	@RequestMapping(value = "/createExam", method = RequestMethod.GET)
	public ModelAndView getExamDetail(@RequestParam int teacherId, @RequestParam int courseId, @RequestParam String examName){
		ModelAndView mav = new ModelAndView();
		Exam exam = examService.createExam(examName, courseId);
		mav.addObject("exam", exam);
		
		mav.addObject("teacherId", teacherId);
		mav.addObject("examId", exam.getExamId());
		
		mav.setViewName("createQuestion");
		return mav;
	}
}
