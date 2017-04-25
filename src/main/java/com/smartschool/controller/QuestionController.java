package com.smartschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionController {

	@RequestMapping(value = "/createQuestion", method = RequestMethod.GET)
	public ModelAndView viewcreateQuestion(@RequestParam int teacherId, @RequestParam int examId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("teacherId", teacherId);
		mav.addObject("examId", examId);
		mav.setViewName("createQuestion");
		return mav;
	}

	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	public ModelAndView saveQuestion(@RequestParam int teacherId, @RequestParam int examId) {
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
	}
}