package com.smartschool.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smartschool.domain.Login;
import com.smartschool.mapper.LoginMapper;

@Repository
public class AuthenticationDAO {

	@Autowired
	private JdbcTemplate jdbcTem;

	public Login getLoginCredential(String email) {
		return DataAccessUtils.singleResult(jdbcTem.query("SELECT * FROM Login where email = ?", new Object[] { email }, new LoginMapper()));
	}
	
	public Login getTeacherLogin(int tid) {
		return jdbcTem.queryForObject("select Login.email, Login.userId, Login.password from Login inner join Teacher on Login.userId = Teacher.tid where Teacher.tid = ?", new Object[] { tid }, new LoginMapper());
	}	
}
