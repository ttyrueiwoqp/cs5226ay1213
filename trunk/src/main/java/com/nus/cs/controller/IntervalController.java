package com.nus.cs.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.DBTO;
import com.nus.cs.util.Constants;
import com.nus.cs.util.DateUtil;

public class IntervalController {
	
	@RequestMapping(value = "/in", method = RequestMethod.GET)
	public String Interval(Locale locale, Model model) {
		return "Interval";
	}


}
