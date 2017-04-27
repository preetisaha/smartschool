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
	
	public Exam publishExam(int examId, String startDate, String endDate) {
		jdbcTem.update("update exam set startDate = ?, endDate = ?, publish = 1 where examId = ?", new Object[] {startDate, endDate, examId});
		return jdbcTem.queryForObject("select * from exam where examId = ?", new Object[] {examId}, new ExamMapper());
	}
	
	public List<Exam> getFinishedExams() {
		return jdbcTem.query("SELECT * FROM exam where endDate < CURDATE() AND publish = 1 AND grade_status = 0", new ExamMapper());
	}
	
	public void updateGradeStatus(int examId) {
		jdbcTem.update("UPDATE exam set grade_status = 1 WHERE examId = ?", new Object[]{examId});
	}
	
	public Exam getExam(int examId) {
		return jdbcTem.queryForObject("SELECT * FROM exam WHERE examId = ?", new Object[]{examId}, new ExamMapper());
	}
}
