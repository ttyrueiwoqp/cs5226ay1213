package com.nus.cs.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.dao.support.SomeRowMapper;
import com.nus.cs.domain.SomeTO;

public class DBDao extends JdbcDaoSupport {
	
	public List<SomeTO> getSomeResult(String a, int b) {
		
		RowMapper<SomeTO> mapper = new SomeRowMapper();
		Object[] param = new Object[]{a, b};
		
		// query (m = a and n = b)
		String sql = " select x, y from some_table where m = ? and n = ? ";
		
		List<SomeTO> ret = super.getJdbcTemplate().query(sql, param, mapper);
		
		return ret;
		
		
	}
	
}