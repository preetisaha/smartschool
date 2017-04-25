package com.smartschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.AuthenticationDAO;
import com.smartschool.DAO.UserDetailsDAO;
import com.smartschool.domain.Login;
import com.smartschool.domain.Teacher;
import com.smartschool.dto.LoginAndTeacher;

@Service
public class UserActionService {
	
	@Autowired
	UserDetailsDAO userDetailDAO;
	
	@Autowired
	AuthenticationDAO authenticationDAO;
	
	public LoginAndTeacher getLoginTeacherDetail(int teacherId){
		Teacher teacher = userDetailDAO.getTeacherDetails(teacherId);
		String teacherName = teacher.getTeacherName();
		String designation = teacher.getDesignation();
		
		Login login = authenticationDAO.getTeacherLogin(teacherId);
		String email = login.getEmail();
		LoginAndTeacher loginAndTeacher = new LoginAndTeacher(teacherName, email, designation);
		return loginAndTeacher;
	}
}



