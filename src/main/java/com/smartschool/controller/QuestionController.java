package com.smartschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.GET)
	public ModelAndView viewcreateQuestion(@RequestParam int teacherId, @RequestParam int examId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("teacherId", teacherId);
		mav.addObject("examId", examId);
		mav.setViewName("createQuestion");
		return mav;
	}

	@RequestMapping(value = "/saveQuestion", method = RequestMethod.POST)
	public ModelAndView getSaveQuestion(@RequestParam int teacherId, @RequestParam int examId,
			@RequestParam int chooseOption, @RequestParam String question, @RequestParam int marks,
			@RequestParam(value="optionSelect", required = false) String[] optionSelectArray,
			@RequestParam(value="optionText", required = false) String[] optionTextArray) {
		ModelAndView mav = new ModelAndView();
		
		questionService.saveQuestion(examId, chooseOption, question, marks, optionSelectArray, optionTextArray);
		
		mav.addObject("teacherId", teacherId);
		mav.addObject("examId", examId);
		mav.setViewName("createQuestion");
		return mav;
	}
}