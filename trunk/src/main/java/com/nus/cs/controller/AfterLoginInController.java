package com.nus.cs.controller;

import java.sql.SQLException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.ThredTO;
import com.nus.cs.service.DBService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AfterLoginInController {
	
	private static final Logger logger = LoggerFactory.getLogger(AfterLoginInController.class);
	
	private DBService dbService = new DBService();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@RequestMapping(value = "/afterlogin", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		ThredTO thredTO = null;
		try {
			 thredTO = dbService.getThreshold();
		} catch (Exception e) {
			dbService.initThreshold();
		}

		return "afterlogin";
	}
	
	
	
}
