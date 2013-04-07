package com.nus.cs.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nus.cs.dao.DBDao;
import com.nus.cs.domain.DBTO;
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
		
		Connection conn = dbDao.createConnection();
		
		while (tempStartDate.before(endDate)) {
			tempEndDate = DateUtil.addMin(tempStartDate, timeInteval);
			DBTO tmp = dbDao.getData(conn, table, DateUtil.getDateAsString(tempStartDate),
					DateUtil.getDateAsString(tempEndDate));
			if (tmp != null) {
				tmp.setInterval(interval);
				results.add(tmp);
			}
			tempStartDate = tempEndDate;
		}
		
		conn.close();

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

	public void initThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();

		dbDao.initThreshold(conn);

		conn.close();

		return;
	}

	public void getThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = dbDao.createConnection();

		dbDao.getThreshold(conn, threshold);

		conn.close();

		return;
	}

}