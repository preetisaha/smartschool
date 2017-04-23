package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Course;

public class CourseMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		int courseId = resultSet.getInt("courseId");
		String courseName = resultSet.getString("courseName");
		int teacherId = resultSet.getInt("teacherId");
		Date startDate = resultSet.getDate("startDate");
		Date endDate = resultSet.getDate("endDate");
		Course course = new Course(courseId, courseName, teacherId, startDate, endDate);
		return course;
	}
}
