package com.nus.cs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.domain.DBTO;

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

	public DBTO getData(Connection conn, String table, String startTime, String endTime) throws SQLException {

		String sql = "SELECT metric_id, metric_name, avg(average) value "
				+ "FROM  dba_hist_sysmetric_summary WHERE metric_id =? "
				+ "and end_time > to_date(?, 'dd/mm/yyyy HH24:MI:SS') "
				+ "and end_time < to_date(?, 'dd/mm/yyyy HH24:MI:SS') "
				+ "GROUP BY metric_id, metric_name";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, table);
		ps.setString(2, startTime);
		ps.setString(3, endTime);

		ResultSet rs = ps.executeQuery();

		DBTO dbTO = new DBTO();
		if (rs.next()) {
			dbTO.setAvgValue(rs.getDouble("value"));
			dbTO.setStartTime(startTime);
			dbTO.setEndTime(endTime);
		}
		
		ps.close();
		
		return dbTO;
	}

	public void initThreshold(Connection conn) throws SQLException {
		
		String sql = " DROP TABLE THRESHOLD_CONFIG ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " CREATE TABLE THRESHOLD_CONFIG ( PARAM_NAME VARCHAR2(100 BYTE), PARAM_WARNING NUMBER(10, 2), PARAM_CRITICAL NUMBER(10, 2) )";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values ('Shared Pool',75,85) ";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values ('Buffer Cache',65,80) ";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values ('Redo Log Buffer',65,90) ";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values ('Memory Area Used For Sorting',60,85) ";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values ('Redo Log Files',1000,9000) ";
		ps = conn.prepareStatement(sql);
		ps.execute();
		
		ps.close();
		
	}

	public void getThreshold(Connection conn, Map<String, Integer> threshold) throws SQLException {
		
		String sql = " SELECT param_name, param_warning, param_critical from threshold_config ";

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			threshold.put(rs.getString("PARAM_NAME") + " Warning",
					rs.getInt("param_warning"));
			threshold.put(rs.getString("PARAM_NAME") + " Critical",
					rs.getInt("param_critical"));
		}

		ps.close();
		
	}
}