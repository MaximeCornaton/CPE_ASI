package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class RequestCrt {
	
	 @Autowired
     CardDao cardDao;
	 
	private static String messageLocal="Bonjour";

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("messageLocal", messageLocal);
		return "index";
	}
	
	@RequestMapping(value = { "/view"}, method = RequestMethod.GET)
    public String view(Model model) {
	    model.addAttribute("myCard", CardDao.getRandomCard()); //pb revenir au point 2
	    return "cardView";
	} 
}