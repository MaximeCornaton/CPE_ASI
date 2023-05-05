package com.sp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.AuthRestService;
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
		if (authRestService.getLogs(user.getName(), user.getPassword())) {
			return user.getId();
		}else {
			return -1;
		}
	}
}
