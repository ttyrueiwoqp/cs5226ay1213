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
public class DBReportController {

	private DBService dbService = new DBService();

	@RequestMapping(value = "/rpt", method = RequestMethod.GET)
	public String sp(Locale locale, Model model) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);

		model.addAttribute("startTime", DateUtil.getDateAsString(before));
		model.addAttribute("endTime", DateUtil.getDateAsString(now));

		return "DBReport";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 */
	@RequestMapping(value = "/rpt2", method = RequestMethod.POST)
	public String home(Model model,
			@ModelAttribute("startTime") String startTime,
			@ModelAttribute("endTime") String endTime,
			@ModelAttribute("x") String x) {

		Calendar cal = Calendar.getInstance();
		Date now = new Date(cal.getTime().getTime());
		Date before = DateUtil.addDay(now, -1);

		List<DBTO> spTOList = null;
		List<DBTO> bcTOList = null;
		List<DBTO> rlbTOList = null;
		List<DBTO> rlfTOList = null;
		List<DBTO> maTOList = null;

		try {
			spTOList = dbService.getDataList(Constants.SHARED_POOL_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now), x);
			bcTOList = dbService.getDataList(Constants.BUFFER_CACHE_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now), x);
			rlbTOList = dbService.getDataList(Constants.REDO_LOG_BUFFER_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now), x);
			rlfTOList = dbService.getDataList(Constants.REDO_LOG_FILES_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now), x);
			maTOList = dbService.getDataList(Constants.MEMORY_AREA_ID,
					DateUtil.getDateAsString(before),
					DateUtil.getDateAsString(now), x);

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

		model.addAttribute("spTOList", spTOList);
		model.addAttribute("bcTOList", bcTOList);
		model.addAttribute("rlbTOList", rlbTOList);
		model.addAttribute("rlfTOList", rlfTOList);
		model.addAttribute("maTOList", maTOList);

		return "DBReport2";
	}

}
