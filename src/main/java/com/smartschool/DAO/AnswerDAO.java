package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Answer;
import com.smartschool.mapper.AnswerMapper;

@Repository
public class AnswerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Answer> getAnswersByQuestionID(int questionId) {
		return jdbcTemplate.query("SELECT * FROM answer WHERE question_id = ?", new Object[]{questionId}, new AnswerMapper());
	}
	
	public void scoreAnswer(int answerId, int marks) {
		jdbcTemplate.update("UPDATE answer set marks = ? WHERE answerId = ?", new Object[]{marks, answerId});
	}
}
