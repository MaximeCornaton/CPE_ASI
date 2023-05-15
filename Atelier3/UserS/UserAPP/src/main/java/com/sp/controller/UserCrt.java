package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asi.equipe1.dto.RegisterDTO;
import com.sp.model.User;
import com.sp.service.UserService;

/**
 * @author paulaubry
 *
 */
@RestController
public class UserCrt {
	
	@Autowired
	private UserService uService;
	
	@PostMapping(value = {"/register"})
	public void addUser(@RequestBody RegisterDTO userDTO) {
		User user = new User(userDTO.getName(),userDTO.getSurname(),userDTO.getPassword(),2000);
		uService.addUser(user);
		
	}
	
	@GetMapping(value = {"/user/{id}"})
	public User getUser(@PathVariable int id) {
		return uService.getUser(id);
	}
	
}

