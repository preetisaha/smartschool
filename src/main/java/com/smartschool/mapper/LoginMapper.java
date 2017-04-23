package com.smartschool.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.smartschool.domain.Login;

public class LoginMapper implements RowMapper<Login>{

	public Login mapRow(ResultSet resultSet, int noOfRows) throws SQLException {
		String email = resultSet.getString("email");
		String password = resultSet.getString("password");
		int userId = resultSet.getInt("userId");
		Login login = new Login(email, password, userId);
		return login;
		
	}

}
