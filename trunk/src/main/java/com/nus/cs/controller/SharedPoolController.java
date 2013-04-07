package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
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
	public String sp(Locale locale, Model model) {
		
		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);
		
		DBTO dbTO = null;
		try {
			dbTO = dbService.getData("2114",DateUtil.getDateAsString(before), DateUtil.getDateAsString(now));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("dbTO", dbTO);

		return "SharedPool";
	}
	
	@RequestMapping(value = "/sp2", method = RequestMethod.GET)
	public String sp2(@ModelAttribute("startTime") String startTime,
    					@ModelAttribute("endTime") String endTime,
    					@ModelAttribute("x") String x,
    					Model model) {
		
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(x);
		
		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);
		
		List<DBTO> dbTOList = null;
		try {
			dbTOList = dbService.getDataList("2114",startTime, endTime, x);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("dbTOList", dbTOList);

		return "SharedPoolSecond";
	}

}