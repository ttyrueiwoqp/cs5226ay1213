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
public class DebugController {
	private static final Logger logger = LoggerFactory
			.getLogger(DebugController.class);
	private DebugDao dbDao = new DebugDao();
	
	@RequestMapping(value = "/debug", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		String error="This area will display error information from sql server.";
		model.addAttribute("success", "false");
		model.addAttribute("error", error);
		List<List<String>> table = new ArrayList<List<String>>();
		model.addAttribute("table", table);
		List<String> header = new ArrayList<String>();
		model.addAttribute("theader", header);
		return "debug";
	}

	@RequestMapping(value = "/debug", method = RequestMethod.POST)
    public String execute(Model model, @ModelAttribute("query")
                            String query, BindingResult result) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
     
		DebugTO dbTO = new DebugTO();
		dbDao.execute(query, dbTO);
		model.addAttribute("success", "true");
		model.addAttribute("error", dbTO.getError());
		model.addAttribute("table", dbTO.getTable());
		model.addAttribute("theader",dbTO.getHeader());
		
		for(String s: dbTO.getHeader())
			System.out.print(s+" ");
		System.out.println();
         
        return "/debug";
    }
}
