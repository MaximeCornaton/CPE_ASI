/**
 * 
 */
package com.sp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.UserService;

/**
 * @author paulaubry
 *
 */
@RestController
public class UserRestCrt {
	
	@Autowired
	private UserService uService;
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		uService.addUser(user);
		
	}
	
	@RequestMapping(value = {"/{id}/cards"}, method = RequestMethod.GET)
	public Set<Card> getCards(@PathVariable int id) {
		return uService.getCards(id);
	}
	
	@RequestMapping(value = {"/user/{id}"}, method = RequestMethod.GET)
	public User getUser(@PathVariable int id) {
		return uService.getUser(id);
	}
	
}

