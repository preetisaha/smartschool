package com.smartschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.AuthenticationDAO;
import com.smartschool.DAO.UserDetailsDAO;
import com.smartschool.domain.Login;
import com.smartschool.domain.Student;
import com.smartschool.domain.Teacher;

@Service
public class LoginService {

	@Autowired
	AuthenticationDAO authDAO;

	@Autowired
	UserDetailsDAO userDetailsDAO;

	/**
	 * get login row from email and check the password authentication. if
	 * password does not match - Return null. if password matches - Get teacher
	 * row using userId. If Teacher found using userId return Teacher object. if
	 * not then return null.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Teacher teacherAuthentication(String email, String password) {
		Login login = authDAO.getLoginCredential(email);

		if (login != null) {
			String pw = login.getPassword();
			int userId = login.getUserId();
			if (pw.equals(password)) {
				return userDetailsDAO.getTeacherDetails(userId);

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
	public Student studentAuthentication(String email, String password) {
		Login login = authDAO.getLoginCredential(email);

		if (login != null) {
			String pw = login.getPassword();
			int userId = login.getUserId();
			if (pw.equals(password)) {
				return userDetailsDAO.getStudentDetails(userId);
			}
		}
		
		return null;
	}
}
