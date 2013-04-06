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
public class DBIController {

	private static final Logger logger = LoggerFactory
			.getLogger(DBIController.class);
	
	private DBService dbService = new DBService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dbi", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome db! The client locale is {}.", locale);
		
		DBTO someResult = new DBTO();
		try {
			someResult = dbService.getData(" SELECT metric_id, metric_name, avg(average) value FROM  dba_hist_sysmetric_summary WHERE metric_id =2114 and end_time > to_date('06/04/2013 10:00:00', 'dd/mm/yyyy HH24:MI:SS') and end_time < to_date('06/04/2013 11:00:00', 'dd/mm/yyyy HH24:MI:SS') GROUP BY metric_id, metric_name ");
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

		return "dbi";
	}

}