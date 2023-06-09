package com.sp.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cRepo;
	
	/**
	 * @param id
	 * @return la carte si elle existe sinon null;
	 */
	public Card getCard(int id) {
		Optional<Card> cOpt = cRepo.findByidCard(id);
		if(cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	/**
	 * @param
	 * @return les cartes
	 */
	public Set<Card> getCards() {
	    Iterable<Card> iterableCards = cRepo.findAll();
	    Set<Card> cards = StreamSupport.stream(iterableCards.spliterator(), false).collect(Collectors.toSet());
	    return cards;
	}
	
	/**
	 * 
	 * @return a random list of 5 cards
	 */
	public Set<Card> get5cards(){
		
	    Set<Card> cards = this.getCards();
	    List<Card> shuffledCards = new ArrayList<>(cards);
	    Collections.shuffle(shuffledCards);
	    return shuffledCards.stream().limit(5).collect(Collectors.toSet());
	

	}

	
	/**
	 * 
	 * @param c
	 * @return The updated card of the repo
	 */
	public Card updateCard(Card c) {
		Card updatedCard = cRepo.save(c);
		return updatedCard;
	}
	
	
	/**
	 * @param id
	 * @return le prix de la carte
	 */
	public int getPrice(int id) {
		return getCard(id).getPrice();
	}
	
	/*
	 * public Boolean doesExist(int id) { return true; }
	 */
	
	/**
	 * 
	 * @param card 
	 */
	  public void addCard(Card c) {
		  cRepo.save(c);
	  }

	public void saveAll(List<Card> cards) {
		cRepo.saveAll(cards);
		
	}
	  
	public Set<Card> getCardBuyable(){
		return cRepo.getCardBuyable();
	}

	 
	
	
	
}