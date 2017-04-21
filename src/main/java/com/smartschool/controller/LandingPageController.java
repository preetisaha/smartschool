package com.smartschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingPageController {
	
	@RequestMapping (value = "/", method = RequestMethod.GET )
	public ModelAndView showLandingPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
