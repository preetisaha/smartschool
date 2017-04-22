package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Student;

public class StudentMapper implements RowMapper<Student>{

	public Student mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		if (noOfRows != 0) {
			int sid = resultSet.getInt("sid");
			String studentName = resultSet.getString("studentName");
			Student teacher = new Student(sid, studentName);
			return teacher;
		} else {
			return null;
		}
	}
}
