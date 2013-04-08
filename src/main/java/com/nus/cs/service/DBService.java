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
import com.nus.cs.domain.ThredTO;
import com.nus.cs.util.ConnectionUtil;
import com.nus.cs.util.Constants;
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
		int timeInterval = Integer.parseInt(interval);
		if(timeInterval < 10){
			timeInterval = 10;
		}
		Date tempStartDate = startDate;
		Date tempEndDate = null;

		ThredTO thredTO = this.getThreshold();

		Connection conn = ConnectionUtil.createConnection();

		while (tempStartDate.before(endDate)) {
			tempEndDate = DateUtil.addMin(tempStartDate, timeInterval);
			DBTO tmp = null;
			if(table.equalsIgnoreCase(Constants.REDO_LOG_FILES_ID)){
				tmp = dbDao.getRedoLogFile(conn,
						DateUtil.getDateAsString(tempStartDate),
						DateUtil.getDateAsString(tempEndDate));
				
			}else{
				tmp = dbDao.getData(conn, table,
						DateUtil.getDateAsString(tempStartDate),
						DateUtil.getDateAsString(tempEndDate));
					
			}
			if (tmp != null) {
				tmp.setInterval(interval);
				this.setDBTOStatus(tmp, thredTO);
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

		Connection conn = ConnectionUtil.createConnection();
		DBTO dbTO = null;
		if(table.equalsIgnoreCase(Constants.REDO_LOG_FILES_ID)){
			dbTO = dbDao.getRedoLogFile(conn, startTime, endTime);

		}else{
			dbTO = dbDao.getData(conn, table, startTime, endTime);

		}
		
		ThredTO thredTO = this.getThreshold();

		this.setDBTOStatus(dbTO, thredTO);

		conn.close();

		return dbTO;
	}

	public void initThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = ConnectionUtil.createConnection();

		dbDao.initThreshold(conn);

		conn.close();

		return;
	}

	public void updateThreshold(ThredTO thredTO) throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = ConnectionUtil.createConnection();

		dbDao.updateThreshold(conn, thredTO);

		conn.close();

		return;
	}

	public ThredTO getThreshold() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Connection conn = ConnectionUtil.createConnection();

		Map<String, Integer> thredMap = dbDao.getThreshold(conn);

		conn.close();

		ThredTO thredTO = new ThredTO();

		thredTO.setSp1(thredMap.get(Constants.SHARED_POOL + Constants.WARNING));
		thredTO.setSp2(thredMap.get(Constants.SHARED_POOL + Constants.CRITICAL));
		thredTO.setBc1(thredMap.get(Constants.BUFFER_CACHE + Constants.WARNING));
		thredTO.setBc2(thredMap
				.get(Constants.BUFFER_CACHE + Constants.CRITICAL));
		thredTO.setRlb1(thredMap.get(Constants.REDO_LOG_BUFFER
				+ Constants.WARNING));
		thredTO.setRlb2(thredMap.get(Constants.REDO_LOG_BUFFER
				+ Constants.CRITICAL));
		thredTO.setRlf1(thredMap.get(Constants.REDO_LOG_FILES
				+ Constants.WARNING));
		thredTO.setRlf2(thredMap.get(Constants.REDO_LOG_FILES
				+ Constants.CRITICAL));
		thredTO.setMa1(thredMap.get(Constants.MEMORY_AREA + Constants.WARNING));
		thredTO.setMa2(thredMap.get(Constants.MEMORY_AREA + Constants.CRITICAL));

		return thredTO;
	}

	private void setDBTOStatus(DBTO dbTO, ThredTO thredTO) {

		if (dbTO.getTable().equals(Constants.SHARED_POOL_ID)) {

			if (dbTO.getAvgValue() < thredTO.getSp1())
				dbTO.setStatus(Constants.HEALTHY);
			else if (dbTO.getAvgValue() < thredTO.getSp2())
				dbTO.setStatus(Constants.MODERATE);
			else
				dbTO.setStatus(Constants.ATTENTION);

		} else if (dbTO.getTable().equals(Constants.BUFFER_CACHE_ID)) {

			if (dbTO.getAvgValue() > thredTO.getBc1())
				dbTO.setStatus(Constants.HEALTHY);
			else if (dbTO.getAvgValue() > thredTO.getBc2())
				dbTO.setStatus(Constants.MODERATE);
			else
				dbTO.setStatus(Constants.ATTENTION);

		} else if (dbTO.getTable().equals(Constants.REDO_LOG_BUFFER_ID)) {

			if (dbTO.getAvgValue() < thredTO.getRlb1())
				dbTO.setStatus(Constants.HEALTHY);
			else if (dbTO.getAvgValue() < thredTO.getRlb2())
				dbTO.setStatus(Constants.MODERATE);
			else
				dbTO.setStatus(Constants.ATTENTION);

		} else if (dbTO.getTable().equals(Constants.REDO_LOG_FILES_ID)) {

			if (dbTO.getAvgValue() < thredTO.getRlf1())
				dbTO.setStatus(Constants.HEALTHY);
			else if (dbTO.getAvgValue() < thredTO.getRlf2())
				dbTO.setStatus(Constants.MODERATE);
			else
				dbTO.setStatus(Constants.ATTENTION);

		} else if (dbTO.getTable().equals(Constants.MEMORY_AREA_ID)) {

			if (dbTO.getAvgValue() > thredTO.getMa1())
				dbTO.setStatus(Constants.HEALTHY);
			else if (dbTO.getAvgValue() > thredTO.getMa2())
				dbTO.setStatus(Constants.MODERATE);
			else
				dbTO.setStatus(Constants.ATTENTION);
		}
	}

}