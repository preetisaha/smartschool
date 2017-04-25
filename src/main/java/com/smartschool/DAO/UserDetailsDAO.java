package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Student;
import com.smartschool.domain.Teacher;
import com.smartschool.mapper.StudentMapper;
import com.smartschool.mapper.TeacherMapper;

@Repository
public class UserDetailsDAO {

	@Autowired
	private JdbcTemplate jdbcTem;
	
	public Teacher getTeacherDetails(int tid) {
		return jdbcTem.queryForObject("SELECT * FROM Teacher where tid = ?", new Object[] { tid },
				new TeacherMapper());
	}
	
	public Student getStudentDetails(int sid) {
		return jdbcTem.queryForObject("SELECT Student.sid, Student.studentName, Login.email FROM Student inner join Login on Student.sid = Login.userId where Student.sid = ?", new Object[] { sid },
				new StudentMapper());
	}
	
	public List<Student> getStudentsByCourse(int courseId) {
		return jdbcTem.query("SELECT StudentTbl.sid, StudentTbl.studentName, Login.email FROM "
				+ "(SELECT Student.sid, Student.studentName FROM Student inner join student_course on Student.sid = student_course.studentId WHERE student_course.student_course_id = ?) as StudentTbl "
				+ "inner join Login on StudentTbl.sid = Login.userId", new Object[]{courseId}, new StudentMapper());
	}
}
