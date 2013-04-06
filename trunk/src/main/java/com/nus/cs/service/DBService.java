package com.nus.cs.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nus.cs.dao.DBDao;
import com.nus.cs.domain.DBTO;
import com.nus.cs.domain.SomeTO;
import com.nus.cs.domain.ThredTO;
import com.nus.cs.util.DateUtil;

public class DBService {

	private DBDao dbDao = new DBDao();

	static public Map<String, Integer> threshold = new HashMap<String, Integer>();

	public List<DBTO> getDataList(String table, String startTime,
			String endTime, String interval) throws ParseException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		List<DBTO> results = new ArrayList<DBTO>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date startDate = new Date(sdf.parse(startTime).getTime());
		Date endDate = new Date(sdf.parse(endTime).getTime());
		int timeInteval = Integer.parseInt(interval);

		Date tempStartDate = startDate;
		Date tempEndDate = null;
		while (tempStartDate.before(endDate)) {
			tempEndDate = DateUtil.addMinuteToDate(tempStartDate, timeInteval);
			DBTO tmp = getData(table, DateUtil.getDateString(tempStartDate),
					DateUtil.getDateString(tempEndDate));
			if (tmp != null) {
				results.add(tmp);
			}
			tempStartDate = tempEndDate;
		}

		return results;

	}

	public DBTO getData(String table, String startTime, String endTime)
			throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();

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
		conn.close();

		return dbTO;
	}

	public void setThreshold() throws SQLException, InstantiationException,
	IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();
		
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
		conn.close();
		
		return;
	}
	
	public void getThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();

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
		conn.close();
		
		System.out.println(threshold.get("Shared Pool Warning"));

		return;
	}

}