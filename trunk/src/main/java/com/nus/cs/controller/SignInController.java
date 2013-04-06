package com.nus.cs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignInController {
	
	private static final Logger logger = LoggerFactory.getLogger(SignInController.class);
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String home(@ModelAttribute("id")
                            String id,@ModelAttribute("password")
                            String password, BindingResult result) {
         
        System.out.println("First Name:" + id + 
                    "Last Name:" + password);
        
        //model.addAttribute("status", status);
        if(id.equals("dba")&&password.equals("dba")){
        	return "/afterlogin";
        }else{
        	return "/home";
        }
    }
	

	
	
}
