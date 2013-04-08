package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class AfterLoginInController {

	private DBService dbService = new DBService();

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@RequestMapping(value = "/afterlogin", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);

		DBTO spTO = null;
		DBTO bcTO = null;
		DBTO rlbTO = null;
		DBTO rlfTO = null;
		DBTO maTO = null;

		try {
			spTO = dbService.getData(Constants.SHARED_POOL_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now));
			bcTO = dbService.getData(Constants.BUFFER_CACHE_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now));
			rlbTO = dbService.getData(Constants.REDO_LOG_BUFFER_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now));
			rlfTO = dbService.getData(Constants.REDO_LOG_FILES_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now));
			maTO = dbService.getData(Constants.MEMORY_AREA_ID,
					DateUtil.getDateAsString(before),
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
		
		model.addAttribute("spTO", spTO);
		model.addAttribute("bcTO", bcTO);
		model.addAttribute("rlbTO", rlbTO);
		model.addAttribute("rlfTO", rlfTO);
		model.addAttribute("maTO", maTO);
		
		return "afterlogin";
	}

}
