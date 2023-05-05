package com.sp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sp.service.AuthRestService;
import com.sp.exception.FonctionalException;
import com.sp.model.User;

@RestController
public class AuthRestCrt {
	
	@Autowired
	AuthRestService authRestService;
	
	/**
	 * Vérfifier le cas où l'authentification n'est pas réussie
	 * @param user
	 * @return "ok" if a user with the passwd communicated has been found, else, not ok
	 */
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public int verifLogin(@RequestBody User user) {
		try {
			if (authRestService.getLogs(user.getName(), user.getPassword())) {
				return user.getId();
			}else {
				return -1;
			}
		} catch (FonctionalException e) {
			 e.printStackTrace(); 
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
			
		}
	}
}