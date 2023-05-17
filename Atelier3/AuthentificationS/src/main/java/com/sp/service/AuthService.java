package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService{
	
	@Autowired 
	UserService userService;
	
	public User getLogs(String surname, String psswd) throws FonctionalException {
		User usr = userService.getUser(surname);
		System.out.println(usr);
		if(usr == null){
			throw new FonctionalException("User inconnu");
		}
		if (usr.getPassword().equals(psswd)) {
			return usr;
		}else {
			throw new FonctionalException("MDP incorrect");
			
		} 
		
	}
	
	
}