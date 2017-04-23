package com.smartschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.AuthenticationDAO;
import com.smartschool.DAO.CourseDAO;
import com.smartschool.DAO.UserDetailsDAO;
import com.smartschool.domain.Course;
import com.smartschool.domain.Login;
import com.smartschool.domain.Student;
import com.smartschool.domain.Teacher;
import com.smartschool.dto.AuthStudent;
import com.smartschool.dto.AuthTeacher;

@Service
public class LoginService {

	@Autowired
	AuthenticationDAO authDAO;

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	

	/**
	 *get login row from email and check login null or not then check password authentication. if
	 * password does not match - Return null. if password matches - Get teacher
	 * row using userId. If Teacher found using userId call courseDAO to get course object.
	 *check course object if null then return null. 
	 *
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public AuthTeacher teacherAuthentication(String email, String password) {
		Login login = authDAO.getLoginCredential(email);

		if (login != null) {
			String pw = login.getPassword();
			int userId = login.getUserId();
			if (pw.equals(password)) {
				Teacher teacher = userDetailsDAO.getTeacherDetails(userId);
				
				if(teacher != null){
					String teacherName = teacher.getTeacherName();
					String designation = teacher.getDesignation();
					int teacherId = teacher.getUserId();
					
					List <Course> course = courseDAO.getTeacherCourseList(teacherId);
					return new AuthTeacher(teacherId, teacherName, designation, email, course);
				} 
			}
		}

		return null;
	}

	/**
	 * get login row from email and check the password authentication. if
	 * password does not match - Return null. if password matches - Get student
	 * row using userId. If Student found using userId return Student object. if
	 * not then return null.
	 * @param email
	 * @param password
	 * @return
	 */
	public AuthStudent studentAuthentication(String email, String password) {
		Login login = authDAO.getLoginCredential(email);

		if (login != null) {
			String pw = login.getPassword();
			int userId = login.getUserId();
			if (pw.equals(password)) {
				Student student = userDetailsDAO.getStudentDetails(userId);
				
				if(student != null){
					String studentName = student.getStudentName();
					int studentId = student.getStudentId();
					List <Course> course = courseDAO.getStudentCourseList(studentId);
					return new AuthStudent(studentId, studentName, email, course);
				} 
			}
		}

		return null;
	}
}
