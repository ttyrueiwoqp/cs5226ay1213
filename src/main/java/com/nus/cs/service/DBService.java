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
import java.util.List;

import com.nus.cs.dao.DBDao;
import com.nus.cs.domain.DBTO;
import com.nus.cs.domain.SomeTO;
import com.nus.cs.util.DateUtil;

public class DBService {
	
	private DBDao dbDao = new DBDao();
	
	public List<SomeTO> getSomeResult(String a, int b) {
		
		List<SomeTO> temp = new ArrayList<SomeTO>();
		
		for (int i = 0; i < 2; i++) {
			
			SomeTO someTO = new SomeTO();
			someTO.setX("result = ");
			someTO.setY(i+b);
			temp.add(someTO);
		}
		
		return temp;
		
		//return dbDao.getSomeResult(a, b);
		
	}
	
	public List<DBTO> getDataList(String table, String startTime, String endTime, String interval) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm");
		Date startDate = new Date(sdf.parse(startTime).getTime());
		Date endDate = new Date(sdf.parse(endTime).getTime());
		int timeInteval = Integer.parseInt(interval);

		
		Date tempStartDate = startDate;
		Date tempEndDate = null;
		while (endDate.before(tempStartDate)) {
			tempEndDate = DateUtil.addMinuteToDate(tempStartDate,timeInteval);
		    
			
			tempStartDate = DateUtil.addMinuteToDate(tempEndDate,
					timeInteval);
		}
		
		
		return null;
		
	}
	
	public DBTO getData(String table, String startTime, String endTime) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Connection conn = dbDao.createConnection();
		
		String sql = "SELECT metric_id, metric_name, avg(average) value" +
				" FROM  dba_hist_sysmetric_summary" +
				" WHERE metric_id =? " +
				" and end_time > to_date(?, 'dd/mm/yyyy HH24:MI:SS') " +
				"and end_time < to_date(?, 'dd/mm/yyyy HH24:MI:SS') " +
				"GROUP BY metric_id, metric_name ";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, table);
		ps.setString(2, startTime);
		ps.setString(3, endTime);
		
		ResultSet rs = ps.executeQuery(sql);
		
		DBTO dbTO = new DBTO();
		rs.next();
		dbTO.setAvgValue(rs.getString("value")+"");
		
		System.out.println(dbTO.getAvgValue());
		
		ps.close();
		conn.close();
		
		return dbTO;	
	}
	
	
}