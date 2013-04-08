package com.nus.cs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.nus.cs.domain.DBTO;
import com.nus.cs.domain.ThredTO;
import com.nus.cs.util.Constants;

public class DBDao extends JdbcDaoSupport {
	
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
			dbTO.setTable(table);
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
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values (?,75,85) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Constants.SHARED_POOL);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values (?,65,80) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Constants.BUFFER_CACHE);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values (?,65,90) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Constants.REDO_LOG_BUFFER);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values (?,1000,9000) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Constants.REDO_LOG_FILES);
		ps.execute();
		
		sql = " insert into THRESHOLD_CONFIG(PARAM_NAME, PARAM_WARNING, PARAM_CRITICAL) values (?,60,85) ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, Constants.MEMORY_AREA);
		ps.execute();
		
		ps.close();
		
	}
	
	public void updateThreshold(Connection conn, ThredTO thredTO) throws SQLException {
		
		String sql = " update threshold_config " +
				" set param_warning = ?, param_critical=? " +
				" where param_name = ? ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1, thredTO.getSp1());
		ps.setDouble(2, thredTO.getSp2());
		ps.setString(3, Constants.SHARED_POOL);
		ps.execute();
		
		ps.setDouble(1, thredTO.getBc1());
		ps.setDouble(2, thredTO.getBc2());
		ps.setString(3, Constants.BUFFER_CACHE);
		ps.execute();
		
		ps.setDouble(1, thredTO.getRlb1());
		ps.setDouble(2, thredTO.getRlb2());
		ps.setString(3, Constants.REDO_LOG_BUFFER);
		ps.execute();
		
		ps.setDouble(1, thredTO.getRlf1());
		ps.setDouble(2, thredTO.getRlf2());
		ps.setString(3, Constants.REDO_LOG_FILES);
		ps.execute();
		
		ps.setDouble(1, thredTO.getMa1());
		ps.setDouble(2, thredTO.getMa2());
		ps.setString(3, Constants.MEMORY_AREA);
		ps.execute();
	}

	public Map<String, Integer> getThreshold(Connection conn) throws SQLException {
		
		Map<String, Integer> thredMap = new HashMap<String, Integer>();
		
		String sql = " SELECT param_name, param_warning, param_critical from threshold_config ";

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			thredMap.put(rs.getString("PARAM_NAME") + Constants.WARNING,
					rs.getInt("param_warning"));
			thredMap.put(rs.getString("PARAM_NAME") + Constants.CRITICAL,
					rs.getInt("param_critical"));
		}

		ps.close();
		
		return thredMap;
	}
}