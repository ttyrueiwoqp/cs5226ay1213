package com.nus.cs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class DBController {
	
	private static final Logger logger = LoggerFactory.getLogger(DBController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome db! The client locale is {}.", locale);
		
		DriverManagerDataSource ds = new DriverManagerDataSource(
				"jdbc:oracle:thin:@dbtune2.comp.nus.edu.sg:40740:a0040740");
		
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = null;
		String sql = " create table dbdb(id varchar(10), name varchar(10)) ";
		String sts = "Hello";
		
		try {
			conn = ds.getConnection("lab2user1", "lab2user1");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			sts = "success";
 
		} catch (Exception e) {
			sts = "fail";
			//throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		model.addAttribute("status", sts );
		model.addAttribute("welcomeMessage", "Welcome To DBDB" );
		
		return "db";
	}
	
}