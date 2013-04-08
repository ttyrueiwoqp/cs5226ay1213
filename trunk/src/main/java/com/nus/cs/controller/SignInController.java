package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
import com.nus.cs.domain.ThredTO;
import com.nus.cs.service.DBService;
import com.nus.cs.util.Constants;
import com.nus.cs.util.DateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignInController {

	private DBService dbService = new DBService();

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String home(Model model,
			@ModelAttribute("id") String id,
			@ModelAttribute("password") String password)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		if (id.equals("dba") && password.equals("dba")) {

			try {
				ThredTO thredTO = dbService.getThreshold();
			} catch (Exception e) {
				dbService.initThreshold();
			}
			
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
			
		} else {
			return "home";
		}
	}

}
