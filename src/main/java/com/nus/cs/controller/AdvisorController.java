package com.nus.cs.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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

import com.nus.cs.dao.DebugDao;
import com.nus.cs.domain.DebugTO;

@Controller
public class AdvisorController {
	private static final Logger logger = LoggerFactory
			.getLogger(DebugController.class);
	private DebugDao dbDao = new DebugDao();
	
	@RequestMapping(value = "/advisor", method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute("attention") String metric) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String query = null;
		if(metric.equalsIgnoreCase("SharedPool")) {
			query = "SELECT shared_pool_size_for_estimate, shared_pool_size_factor, estd_lc_time_saved FROM v$shared_pool_advice"; 
			
		}
		else if(metric.equalsIgnoreCase("BufferCache")){
			query = "select size_for_estimate, buffers_for_estimate, estd_physical_read_factor, estd_physical_reads from v$db_cache_advice";
		
		}
		else if(metric.equalsIgnoreCase("MemSort")) {
			
		}
		else if(metric.equalsIgnoreCase("RedoLogBuffer")) {
			
		}
		else {
			
		}
		DebugTO dbTO = new DebugTO();
		dbDao.execute(query, dbTO);
		model.addAttribute("table", dbTO.getTable());
		model.addAttribute("theader",dbTO.getHeader());
		model.addAttribute("metric", metric);
		return "advisor";
	}
}
