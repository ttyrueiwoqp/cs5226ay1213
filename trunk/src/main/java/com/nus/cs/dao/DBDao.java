package com.nus.cs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.dao.support.SomeRowMapper;
import com.nus.cs.domain.SomeTO;

public class DBDao extends JdbcDaoSupport {
	
	
	
	public Connection createConnection() {
		
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String connectionURL = "jdbc:oracle:thin:@dbtune.comp.nus.edu.sg:40953:a0040953";
		String userID = "system";
		String userPassword = "system";
		Connection conn = null;

		Properties conProps = new Properties();
		conProps.put("user", userID);
		conProps.put("password", userPassword);
		conProps.put("defaultRowPrefetch", "15");
		
		try {
			Class.forName(driverClass).newInstance();

			conn = DriverManager.getConnection(connectionURL, conProps);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

//		String sqlGetSnapId = "select max(snap_id) FROM dba_hist_snapshot";
//
//		String sqlGetID = "SELECT DBID FROM V$DATABASE";
//		String sts = "Hello";
//		Statement statement = null;
//
//		String dbid = "";
//		String snapid = "";
//		try {
//			Class.forName(driverClass).newInstance();
//			conn = DriverManager.getConnection(connectionURL, conProps);
//			statement = conn.createStatement();
//			dbid = getInfo(sqlGetID, statement);
//			snapid = getInfo(sqlGetSnapId, statement);
//			int castSnapId = Integer.parseInt(snapid);
//			String sqlGetReport = "SELECT output FROM TABLE (dbms_workload_"
//					+ "repository.awr_report_text (" + dbid + ",1,"
//					+ (castSnapId - 1) + "," + castSnapId + "))";
//			sts = getInfo(sqlGetReport, statement);
//			statement.close();
//			
//
//		} catch (Exception e) {
//			sts = "fail";
//			e.printStackTrace();
//			// throw new RuntimeException(e);
//
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//				}
//			}
//		}
		
	}
	public List<SomeTO> getSomeResult(String a, int b) {
		
		RowMapper<SomeTO> mapper = new SomeRowMapper();
		Object[] param = new Object[]{a, b};
		
		// query (m = a and n = b)
		String sql = " select x, y from some_table where m = ? and n = ? ";
		
		List<SomeTO> ret = super.getJdbcTemplate().query(sql, param, mapper);
		
		return ret;
		
		
	}
	
}