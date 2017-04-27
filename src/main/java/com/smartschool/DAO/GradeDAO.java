package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Grade;
import com.smartschool.mapper.GradeMapper;

@Repository
public class GradeDAO {

	@Autowired
	private JdbcTemplate jdbcTem;
	
	public void updateGrade(int studentId, int examId, int courseId, int grade) {
		jdbcTem.update("INSERT INTO grades (id_student, id_exam, id_course, grade)"
				+ " VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE grade = grade + ?", new Object[]{studentId, 
						examId, courseId, grade, grade});
	}
	
	public List<Grade> getGradesByExam(int examId) {
		return jdbcTem.query("SELECT grades.id_student, grades.id_exam, grades.id_course, grades.grade, "
				+ "Student.studentName FROM grades INNER JOIN Student ON grades.id_student = Student.sid "
				+ "WHERE grades.id_exam = ?", new Object[]{examId}, new GradeMapper());
	}
	
	public void overRideGrade(int studentId, int examId, int courseId, int grade) {
		jdbcTem.update("UPDATE grades SET grade = ? WHERE id_student = ? "
				+ "AND id_exam = ? AND id_course = ?", new Object[]{grade, studentId, examId, courseId});
	}
	
	public List<Grade> getStudentGrades(int studentId, int courseId) {
		return jdbcTem.query("SELECT grades.id_student, grades.id_exam, grades.id_course, grades.grade, "
				+ "Student.studentName FROM grades INNER JOIN Student ON grades.id_student = Student.sid "
				+ "WHERE grades.id_course = ? AND grades.id_student = ?", new Object[]{courseId, studentId}, new GradeMapper());
	}
}
