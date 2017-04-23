package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.smartschool.domain.Teacher;

public class TeacherMapper implements RowMapper<Teacher> {

	public Teacher mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		int tid = resultSet.getInt("tid");
		String teacherName = resultSet.getString("teacherName");
		String designation = resultSet.getString("designation");
		Teacher teacher = new Teacher(tid, teacherName, designation);
		return teacher;
	}

}
