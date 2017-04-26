package com.smartschool.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradeDAO {

	@Autowired
	private JdbcTemplate jdbcTem;
	
	public void updateGrade(int studentId, int examId, int courseId, int grade) {
		jdbcTem.update("INSERT INTO grades (id_student, id_exam, id_course, grade)"
				+ " VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE grade = grade + ?", new Object[]{studentId, 
						examId, courseId, grade, grade});
	}
}
