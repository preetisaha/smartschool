package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Answer;

public class AnswerMapper implements RowMapper<Answer>{

	@Override
	public Answer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int answerId = resultSet.getInt("answerId");
		int question_id = resultSet.getInt("question_id");
		String answer = resultSet.getString("answer");
		int student_id = resultSet.getInt("student_id");
		int marks = resultSet.getInt("marks");
		
		return new Answer(answerId, question_id, answer, student_id, marks);
	}
}
