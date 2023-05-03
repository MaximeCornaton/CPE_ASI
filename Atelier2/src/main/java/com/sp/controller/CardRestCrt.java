package com.sp.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;

@RestController
public class CardRestCrt {
	
	
	@RequestMapping(method=RequestMethod.POST,value="/addcard")
	public void addCard(@RequestBody Card card) {
		System.out.println(card);
	}

}


