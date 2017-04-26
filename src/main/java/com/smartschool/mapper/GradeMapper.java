package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Grade;

public class GradeMapper implements RowMapper<Grade>{

	@Override
	public Grade mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		
		int id_student = resultSet.getInt("id_student");
		int id_exam = resultSet.getInt("id_exam");
		int id_course = resultSet.getInt("id_course");
		int grade = resultSet.getInt("grade");
		String studentName = resultSet.getString("studentName");
		
		Grade gradeObj = new Grade(id_student, id_exam, id_course, grade, studentName);
		return gradeObj;
	}

	
}
