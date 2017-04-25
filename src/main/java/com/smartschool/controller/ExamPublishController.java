package com.smartschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExamPublishController {

	@RequestMapping(value="/publishExam", method = RequestMethod.GET)
	public ModelAndView publishExam(@RequestParam int courseId, @RequestParam int teacherId, 
			@RequestParam int examId, @RequestParam String startDate, @RequestParam String endDate) {
		
		return null;
	} 
}
