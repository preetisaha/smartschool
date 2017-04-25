package com.smartschool.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Course;
import com.smartschool.mapper.CourseMapper;

@Repository
public class CourseDAO {
	@Autowired
	private JdbcTemplate jdbcTem;

	public List<Course> getTeacherCourseList(int tid) {
		return jdbcTem.query("SELECT * FROM course where teacherId = ?", new Object[] { tid }, new CourseMapper());
		
	}
	
	public List<Course> getStudentCourseList(int studentId) {
		return jdbcTem.query("select course.courseId, course.courseName, course.teacherId, course.startDate, course.endDate from course inner join student_course on course.courseId = student_course.student_course_id where student_course.studentId = ?"
				, new Object[] { studentId }, new CourseMapper());
	}
	
	public Course getCourseByID(int courseId) {
		return jdbcTem.queryForObject("select * from course where courseId = ?", new Object[] {courseId}, new CourseMapper());
	}
}

