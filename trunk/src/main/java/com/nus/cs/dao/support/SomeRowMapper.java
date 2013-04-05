package com.nus.cs.dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nus.cs.domain.SomeTO;

public class SomeRowMapper implements RowMapper<SomeTO>{

	@Override
	public SomeTO mapRow(ResultSet rs, int rownum) throws SQLException {
		
		SomeTO bean = new SomeTO();
		
		bean.setX(rs.getString("x"));
		bean.setY(rs.getInt("y"));
		
		return bean;
	}
	
	
}