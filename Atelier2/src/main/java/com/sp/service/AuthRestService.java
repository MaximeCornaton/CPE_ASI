package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;

@Service
public class AuthRestService{
	
	@Autowired 
	UserService userService;
	
	public boolean getLogs(String name, String psswd) {
		boolean res;
		User usr = userService.getUser(name);
		if (usr.getPassword().equals("passwd")) {
			res = true;
		}else {
			res = false;
		}
		return res; 
		
	}
	
	
}