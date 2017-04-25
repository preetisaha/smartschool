package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.smartschool.domain.Choice;

public class ChoiceMapper implements RowMapper<Choice>{

	@Override
	public Choice mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int multipleChoiceId = resultSet.getInt("multipleChoiceId");
		boolean isValid = resultSet.getBoolean("isValid");
		String choice = resultSet.getString("choice");
		int questionId = resultSet.getInt("questionId");
		return new Choice(multipleChoiceId, isValid, choice, questionId);
	}
}
