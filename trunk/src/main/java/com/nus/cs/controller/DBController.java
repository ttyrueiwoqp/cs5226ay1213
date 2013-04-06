package com.nus.cs.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
import com.nus.cs.domain.SomeTO;
import com.nus.cs.service.DBService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBController {

	private static final Logger logger = LoggerFactory
			.getLogger(DBController.class);
	
	private DBService dbService = new DBService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome db! The client locale is {}.", locale);
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String connectionURL = "jdbc:oracle:thin:@dbtune.comp.nus.edu.sg:40953:a0040953";
		String userID = "system";
		String userPassword = "system";
		Connection conn = null;

		Properties conProps = new Properties();
		conProps.put("user", userID);
		conProps.put("password", userPassword);
		conProps.put("defaultRowPrefetch", "15");

		String sqlGetSnapId = "select max(snap_id) FROM dba_hist_snapshot";

		String sqlGetID = "SELECT DBID FROM V$DATABASE";
		String sts = "Hello";
		Statement statement = null;

		String dbid = "";
		String snapid = "";
		try {
			Class.forName(driverClass).newInstance();
			conn = DriverManager.getConnection(connectionURL, conProps);
			statement = conn.createStatement();
			dbid = getInfo(sqlGetID, statement);
			snapid = getInfo(sqlGetSnapId, statement);
			int castSnapId = Integer.parseInt(snapid);
			String sqlGetReport = "SELECT output FROM TABLE (dbms_workload_"
					+ "repository.awr_report_text (" + dbid + ",1,"
					+ (castSnapId - 1) + "," + castSnapId + "))";
			String sqlll = "SELECT metric_id, metric_name, avg(average) value FROM  dba_hist_sysmetric_summary WHERE metric_id ='2114' and end_time > to_date('06/04/2013 10:00:00', 'dd/mm/yyyy HH24:MI:SS') and end_time < to_date('06/04/2013 11:00:00', 'dd/mm/yyyy HH24:MI:SS') GROUP BY metric_id, metric_name";
			sts = getInfo(sqlll, statement);
			statement.close();
			

		} catch (Exception e) {
			sts = "fail";
			e.printStackTrace();
			// throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		model.addAttribute("status", sts);
		model.addAttribute("welcomeMessage", "Welcome To DBDB");
		
		DBTO someResult = new DBTO();
		try {
			someResult = dbService.getData(" SELECT metric_id, metric_name, avg(average) value FROM  dba_hist_sysmetric_summary WHERE metric_id ='2114' and end_time > to_date('06/04/2013 10:00:00', 'dd/mm/yyyy HH24:MI:SS') and end_time < to_date('06/04/2013 11:00:00', 'dd/mm/yyyy HH24:MI:SS') GROUP BY metric_id, metric_name ");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("someResult", someResult.getAvgValue());

		return "db";
	}
	
	@RequestMapping(value = "/db", method = RequestMethod.POST)
    public String addStatus(@ModelAttribute("status")
                            String status, BindingResult result) {
         
        System.out.println("First Name:" + status + 
                    "Last Name:" + status);
        
        //model.addAttribute("status", status);
         
        return "/db";
    }

	private String getInfo(String sqlGetID, Statement statement)
			throws SQLException {
		ResultSet resultSet;
		String data = "";
		int numberOfColumns;
		resultSet = statement.executeQuery(sqlGetID);
		numberOfColumns = resultSet.getMetaData().getColumnCount();
		while (resultSet.next()) {
			for (int i = 1; i <= numberOfColumns; i++) {
				data = data + resultSet.getString(i);
			}
		}
		return data;
	}

}