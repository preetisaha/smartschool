package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Course;
import com.smartschool.domain.Exam;
import com.smartschool.mapper.CourseMapper;
import com.smartschool.mapper.ExamMapper;

@Repository
public class ExamDAO {

	@Autowired
	private JdbcTemplate jdbcTem;
	
	public Exam createExam(String examName, int courseId){
		jdbcTem.update("insert into exam (examName, publish, courseId, grade_status) values (?, 0, ?,0)", new Object[] { examName, courseId });
		return jdbcTem.queryForObject( "select * from exam where examId = (select last_insert_id())", new ExamMapper());
	}
	
	public List<Exam> getExamList(int courseId) {
		return jdbcTem.query("SELECT * FROM exam where courseId = ?", new Object[] { courseId }, new ExamMapper());
		
	}
}
