package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
import com.nus.cs.service.DBService;
import com.nus.cs.util.Constants;
import com.nus.cs.util.DateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RedoLogBufferController {

	private DBService dbService = new DBService();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/rlb", method = RequestMethod.GET)
	public String rlb(Locale locale, Model model) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);

		DBTO dbTO = null;
		try {
			dbTO = dbService.getData(Constants.REDO_LOG_BUFFER_ID, DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now));
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

		return "RedoLogBuffer";
	}

	@RequestMapping(value = "/rlb2", method = RequestMethod.POST)
	public String rlb2(Model model,
			@ModelAttribute("startTime") String startTime,
			@ModelAttribute("endTime") String endTime,
			@ModelAttribute("x") String x) {

		List<DBTO> dbTOList = null;
		try {
			dbTOList = dbService.getDataList(Constants.REDO_LOG_BUFFER_ID, startTime, endTime, x);
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

		return "RedoLogBuffer2";
	}

	@RequestMapping(value = "/rlb3", method = RequestMethod.POST)
	public String rlb3(Model model, 
			@ModelAttribute("startend") String startend,
			@ModelAttribute("y") String y) {

		String[] result = startend.split(",");
		String startTime = result[0];
		String endTime = result[1];

		List<DBTO> dbTOList = null;
		try {
			dbTOList = dbService.getDataList(Constants.REDO_LOG_BUFFER_ID, startTime, endTime, y);
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

		return "RedoLogBuffer3";
	}

}