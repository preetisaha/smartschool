package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Question;

public class QuestionMapper implements RowMapper<Question>{

	@Override
	public Question mapRow(ResultSet resultSet, int noOfRows) throws SQLException {

		int questionId = resultSet.getInt("questionId");
		String question = resultSet.getString("question");
		int marks = resultSet.getInt("marks");
		boolean multipleChoice = resultSet.getBoolean("multipleChoice");
		int examId = resultSet.getInt("examId");
		return new Question(questionId, question, marks, multipleChoice, examId);
	}

	
}
