package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		int sid = resultSet.getInt("sid");
		String studentName = resultSet.getString("studentName");
		String email = resultSet.getString("email");
		Student student = new Student(sid, studentName, email);
		return student;
	}
}
