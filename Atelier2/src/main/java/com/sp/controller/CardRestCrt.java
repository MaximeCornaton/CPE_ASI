package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.CardService;

import com.sp.model.Card;

@RestController
public class CardRestCrt {
	
	@Autowired
	private CardService CardService;

	
	@RequestMapping(method=RequestMethod.POST,value="/addcard")
	public void addCard(@RequestBody Card card) {
		System.out.println(card);
	}

}


