package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Choice;
import com.smartschool.domain.Question;
import com.smartschool.mapper.ChoiceMapper;
import com.smartschool.mapper.QuestionMapper;

@Repository
public class QuestionDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Question saveQuestion(int examId, boolean multipleChoice, String question, int marks){
		jdbcTemplate.update("insert into question (examId, question, marks, multipleChoice) values (?, ?, ?, ?)", new Object[] {examId, question, marks, multipleChoice});
		return jdbcTemplate.queryForObject( "select * from question where questionId = (select last_insert_id())", new QuestionMapper());
	}
	
	public Choice saveChoice(int questionId, boolean isValid, String choice){
		jdbcTemplate.update("insert into multiple_choice (questionId, isValid, choice) values (?, ?, ?)", new Object[] {questionId, isValid, choice});
		return jdbcTemplate.queryForObject( "select * from multiple_choice where multipleChoiceId = (select last_insert_id())", new ChoiceMapper());
	}
	
	public List<Question> getMultiChoiceQuestions(int examId) {
		return jdbcTemplate.query("SELECT * FROM question WHERE examId = ? AND multipleChoice = 1", new Object[] {examId}, new QuestionMapper());
	}
	
	public List<Choice> getCorrectChoice(int questionId) {
		return jdbcTemplate.query("SELECT * FROM multiple_choice where questionId = ? AND isValid = 1", new Object[]{questionId}, new ChoiceMapper());
	}

}
