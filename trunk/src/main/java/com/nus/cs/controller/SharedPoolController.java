package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
import com.nus.cs.service.DBService;
import com.nus.cs.util.DateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SharedPoolController {

	private static final Logger logger = LoggerFactory
			.getLogger(DBIController.class);
	
	private DBService dbService = new DBService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sp", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome db! The client locale is {}.", locale);
		
		DBTO dbTO = null;
		try {
			Calendar cal = Calendar.getInstance();
			Date now = new Date(cal.getTime().getTime());
			Date before = DateUtil.addDay(now, -1);
			dbTO = dbService.getData("2114",DateUtil.getDateAsString(before), DateUtil.getDateAsString(now));
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
		
		
		model.addAttribute("dbTO", dbTO);

		return "SharedPool";
	}
	
	@RequestMapping(value = "/sp2", method = RequestMethod.GET)
	public String home2(@ModelAttribute("startTime")
    					String startTime, 
    					@ModelAttribute("endTime")
    					String endTime, BindingResult result) {
		
		System.out.println(startTime);
		System.out.println(endTime);
		
		//model.addAttribute("dbTO", dbTO);

		return "SharedPoolSecond";
	}

}