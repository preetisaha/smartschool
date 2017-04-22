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

}
