package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.UserFormDTO;

@Controller 
public class RequestCrt {
	
	@Autowired
	UserDao userDao;


	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "card";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String register(Model model) {
		UserFormDTO userForm = new UserFormDTO();
		model.addAttribute("form","register");
		model.addAttribute("addUserForm", userForm);
		return "user";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute("addUserForm") UserFormDTO userForm) {
		userDao.addUser(userForm.getName(),userForm.getSurname(),userForm.getPassword());
		System.out.print(userDao);
		return "card";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("form","login");
		return "user";
	}

}
