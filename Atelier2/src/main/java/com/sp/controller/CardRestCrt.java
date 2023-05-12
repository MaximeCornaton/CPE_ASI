package com.sp.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.CardDTO;
import com.sp.service.CardService;


@RestController
public class CardRestCrt {
	
	@Autowired
	private CardService CardService;

	/**
	 * 
	 * @param id
	 * @return la carte si elle existe sinon null;
	 */
	@RequestMapping(method=RequestMethod.GET,value="/card/{id}")
	public CardDTO getCard(@PathVariable int id) {
		Card card = CardService.getCard(id);
		CardDTO cardDto = new CardDTO();
		BeanUtils.copyProperties(card, cardDto);
		return cardDto;
	}
	
	/**
	 * 
	 * @return 
	 * @return les cartes existantes
	 */
	@RequestMapping(method=RequestMethod.GET,value="/cards")
	public Set<Card> getCards() {
		return CardService.getCards();
	}
	
	/**
	 * 
	 * @param c
	 */
	@RequestMapping(method=RequestMethod.POST,value="/cards")
	public void addCard(@RequestBody Card c) {
		CardService.addCard(c);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cardsToBuy")
	public Set<Card> getCardsToBuy() {
		return CardService.getCards();
	}
	/*
	 * private static boolean isInteger(String s) { boolean isValid = true; try{
	 * Integer.parseInt(s); } catch(NumberFormatException nfe){ isValid = false; }
	 * return isValid; }
	 */

}


