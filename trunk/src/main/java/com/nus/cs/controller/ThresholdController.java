package com.nus.cs.controller;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ThresholdController {

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/th", method = RequestMethod.GET)
	public String Threshold(Locale locale, Model model) {
		
		return "Threshold";
	}

}