package com.sp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sp.service.AuthService;

@RestController
public class AuthCrt {
	
	@Autowired
	AuthRestService authRestService;
	
	/**
	 * Vérfifier le cas où l'authentification n'est pas réussie
	 * @param user
	 * @return "ok" if a user with the passwd communicated has been found, else, not ok
	 */
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public int verifLogin(@RequestBody User user) {
		System.out.println(user);
		try {
			User usr = authRestService.getLogs(user.getSurname(), user.getPassword());
			//System.out.println(usr.getId());
			return usr.getId();
		} catch (FonctionalException e) {
			 e.printStackTrace(); 
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
			
		}
	}
}