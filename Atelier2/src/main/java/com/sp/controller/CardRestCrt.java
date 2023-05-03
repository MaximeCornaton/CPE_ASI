package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	
	@RequestMapping(method=RequestMethod.GET,value="/getcard/{id}")
	public void getCard(@PathVariable String id) {
		System.out.println(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getcards")
	public void getCards() {
		System.out.println("id");
	}

}


