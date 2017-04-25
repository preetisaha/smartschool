package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import com.smartschool.domain.Exam;

public class ExamMapper implements RowMapper<Exam> {

	public Exam mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		
		int examId = resultSet.getInt("examId");
		String examName = resultSet.getString("examName");
		Date startDate = resultSet.getDate("startDate");
		Date endDate = resultSet.getDate("endDate");
		boolean publish = resultSet.getBoolean("publish");
		boolean grade_status = resultSet.getBoolean("grade_status");
		int courseId = resultSet.getInt("courseId");
		
		Exam exam = new Exam(examId, examName, startDate, endDate, courseId, publish, grade_status);
		return exam;
	}

}
