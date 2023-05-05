package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.exception.FonctionalException;
import com.sp.model.User;

@Service
public class AuthRestService{
	
	@Autowired 
	UserService userService;
	
	public boolean getLogs(String name, String psswd) throws FonctionalException {
		boolean res;
		User usr = userService.getUser(name);
		if(usr == null){
			throw new FonctionalException("User inconnu");
		}
		if (usr.getPassword().equals(psswd)) {
			res = true;
		}else {
			throw new FonctionalException("MDP incorrect");
			
		}
		return res; 
		
	}
	
	
}