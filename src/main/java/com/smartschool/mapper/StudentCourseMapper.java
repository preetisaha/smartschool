package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.StudentCourse;

public class StudentCourseMapper implements RowMapper<StudentCourse> {

	public StudentCourse mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		if (noOfRows != 0) {
			int studentId = resultSet.getInt("studentId");
			int studentCourseId = resultSet.getInt("student_course_id");
			StudentCourse studentCourse = new StudentCourse(studentId, studentCourseId);
			return studentCourse;
		} else {
			return null;
		}
	}
}
