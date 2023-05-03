package com.sp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.service.CardService;


@RestController
public class CardRestCrt {
	
	@Autowired
	private CardService CardService;

	
	@RequestMapping(method=RequestMethod.GET,value="/getcard/{id}")
	public Card getCard(@PathVariable int id) {
		return CardService.getCard(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getcards")
	public Set<Card> getCards() {
		return CardService.getCards();
	}
	
	/*
	 * private static boolean isInteger(String s) { boolean isValid = true; try{
	 * Integer.parseInt(s); } catch(NumberFormatException nfe){ isValid = false; }
	 * return isValid; }
	 */

}


