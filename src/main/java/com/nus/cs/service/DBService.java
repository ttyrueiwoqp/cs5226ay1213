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
		
		DBTO ret = dbDao.getData(conn, table, startTime, endTime);

		conn.close();

		return ret;
	}

	public void setThreshold() throws SQLException, InstantiationException,
	IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();
		
		dbDao.setThreshold(conn);
		
		conn.close();
		
		return;
	}
	
	public void getThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();

		dbDao.getThreshold(conn);
		
		conn.close();

		return;
	}

}