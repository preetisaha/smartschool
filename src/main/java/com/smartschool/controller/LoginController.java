package com.smartschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smartschool.domain.Student;
import com.smartschool.domain.Teacher;
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
			Teacher teacher = loginService.teacherAuthentication(email, password);
			if(teacher == null){
				mav.addObject("error", true);
				mav.setViewName("home");
			} else {
			mav.addObject("teacher", teacher);
			mav.setViewName("teacherHome");
			}
		}
		
		else {
			Student student = loginService.studentAuthentication(email, password);
			if(student == null){
				mav.addObject("error", true);
				mav.setViewName("home");
			} else {
			mav.addObject("student", student);
			mav.setViewName("studentHome");
			}
		}
		return mav;
	}
}
