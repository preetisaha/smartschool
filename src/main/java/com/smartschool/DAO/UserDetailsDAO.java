package com.smartschool.DAO;

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
		return jdbcTem.queryForObject("SELECT * FROM Student where sid = ?", new Object[] { sid },
				new StudentMapper());
	}
}
