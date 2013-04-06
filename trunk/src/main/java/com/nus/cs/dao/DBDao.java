package com.nus.cs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.dao.support.SomeRowMapper;
import com.nus.cs.domain.SomeTO;

public class DBDao extends JdbcDaoSupport {

	public Connection createConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String connectionURL = "jdbc:oracle:thin:@dbtune.comp.nus.edu.sg:40953:a0040953";
		String userID = "system";
		String userPassword = "system";
		Connection conn = null;

		Properties conProps = new Properties();
		conProps.put("user", userID);
		conProps.put("password", userPassword);
		conProps.put("defaultRowPrefetch", "15");

		Class.forName(driverClass).newInstance();
		conn = DriverManager.getConnection(connectionURL, conProps);
		
		return conn;		
	}
}