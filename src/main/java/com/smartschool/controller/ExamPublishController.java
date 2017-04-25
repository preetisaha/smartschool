package com.smartschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.dto.ExamStatus;
import com.smartschool.dto.LoginAndTeacher;
import com.smartschool.service.ExamPublishService;
import com.smartschool.service.ExamService;
import com.smartschool.service.UserActionService;

@Controller
public class ExamPublishController {

	@Autowired
	ExamPublishService examPublishService;
	
	@Autowired
	UserActionService userActionService;
	
	@Autowired
	ExamService examService;
	
	@RequestMapping(value="/publishExam", method = RequestMethod.GET)
	public ModelAndView publishExam(@RequestParam int courseId, @RequestParam int teacherId, 
			@RequestParam int examId, @RequestParam String startDate, @RequestParam String endDate) {
		examPublishService.publishExam(examId, startDate, endDate);
		
		ModelAndView mav = new ModelAndView();
		LoginAndTeacher loginAndTeacher  = userActionService.getLoginTeacherDetail(teacherId);
		mav.addObject("loginAndTeacher", loginAndTeacher);
		mav.addObject("courseId", courseId);
		mav.addObject("teacherId", teacherId);
		
		ExamStatus examStatus = examService.getExamStatus(courseId);
		mav.addObject("examStatus", examStatus);
		mav.setViewName("teacherAction");
		return mav;
	} 
}
