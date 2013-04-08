package com.nus.cs.controller;

import java.sql.SQLException;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nus.cs.domain.ThredTO;
import com.nus.cs.service.DBService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ThresholdController {

	private DBService dbService = new DBService();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/th", method = RequestMethod.GET)
	public String Threshold(Locale locale, Model model) {
		
		ThredTO thredTO = null;
		try {
			thredTO = dbService.getThreshold();
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
		
		model.addAttribute("thredTO", thredTO);
		
		return "Threshold";
	}
	
	@RequestMapping(value = "/th", method = RequestMethod.POST)
	public String Threshold(Model model,
			@ModelAttribute("sp1") double sp1,
			@ModelAttribute("sp2") double sp2,
			@ModelAttribute("bc1") double bc1,
			@ModelAttribute("bc2") double bc2,
			@ModelAttribute("rlb1") double rlb1,
			@ModelAttribute("rlb2") double rlb2,
			@ModelAttribute("rlf1") double rlf1,
			@ModelAttribute("rlf2") double rlf2,
			@ModelAttribute("ma1") double ma1,
			@ModelAttribute("ma2") double ma2) {
		
		ThredTO thredTO = new ThredTO();
		
		thredTO.setSp1(sp1);
		thredTO.setSp2(sp2);
		thredTO.setBc1(bc1);
		thredTO.setBc2(bc2);
		thredTO.setRlb1(rlb1);
		thredTO.setRlb2(rlb2);
		thredTO.setRlf1(rlf1);
		thredTO.setRlf2(rlf2);
		thredTO.setMa1(ma1);
		thredTO.setMa2(ma2);
		
		try {
			dbService.updateThreshold(thredTO);
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
		
		model.addAttribute("thredTO", thredTO);
		
		return "Threshold";
	}

}