package com.smartschool.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.dto.AuthStudent;
import com.smartschool.dto.AuthTeacher;
import com.smartschool.service.LoginService;

@Controller
public class LoginController{
	
	@Autowired
	LoginService loginService;
	
	/**
	 * loginAuthentication method is checking usertype and calling LoginService methods accordingly. 
	 * Get user object from loginService and sent it to view
	 * @param usertype
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public ModelAndView loginAuthentication(@RequestParam String usertype, @RequestParam String email, @RequestParam String password){
		ModelAndView mav = new ModelAndView();
		if(usertype.equals("1")){
			mav.setViewName("adminHome");
		}
		
		else if(usertype.equals("2")){
			AuthTeacher authTeacher = loginService.teacherAuthentication(email, password);
			if(authTeacher == null){
				mav.addObject("error", true);
				mav.setViewName("home");
			} else {
				mav.addObject("authTeacher", authTeacher);
				mav.setViewName("teacherHome");
			}
		}
		
		else {
			AuthStudent authStudent = loginService.studentAuthentication(email, password);
			if(authStudent == null){
				mav.addObject("error", true);
				mav.setViewName("home");
			} else {
				mav.addObject("authStudent", authStudent);
				mav.setViewName("studentHome");
			}
		}
		return mav;
	}
}
