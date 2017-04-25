package com.smartschool.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartschool.DAO.CourseDAO;
import com.smartschool.DAO.ExamDAO;
import com.smartschool.DAO.UserDetailsDAO;
import com.smartschool.domain.Course;
import com.smartschool.domain.Exam;
import com.smartschool.domain.Student;
import com.smartschool.domain.Teacher;

@Service
public class ExamPublishService {

	@Autowired
	ExamDAO examDAO;
	
	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	public void publishExam(int examId, String startDate, String endDate) {
		Exam exam = examDAO.publishExam(examId, startDate, endDate);
		
		Course course = courseDAO.getCourseByID(exam.getCourseId());
		
		Teacher teacher = userDetailsDAO.getTeacherDetails(course.getTeacherId());
		
		List<Student> students = userDetailsDAO.getStudentsByCourse(course.getCourseId());
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailProperties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(mailProperties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("preeti.das4u@gmail.com", "preetibitan!@#");
					}
				  });
		
		for (Student student : students) {
			try { 
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress("preeti.das4u@gmail.com"));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(student.getEmail()));
					message.setSubject("Please take the following Exam - " + exam.getExamName());
					message.setText("Please take the following Exam - " + exam.getExamName() + " prior to " + exam.getEndDate()
					+ " using the following link: ");
					Transport.send(message);
	         } catch(Exception e) {
	        	 System.out.println("Failed to send email to - " + student.getEmail());
	         }
		}
	}
}
