package com.nus.cs.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
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
		
		List<DBTO> someResult = null;
		try {
			try {
				someResult = dbService.getDataList("2114","06/04/2013 14:00", "06/04/2013 16:00", "30");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		
		model.addAttribute("someResult", someResult);

		return "dbi";
	}

}