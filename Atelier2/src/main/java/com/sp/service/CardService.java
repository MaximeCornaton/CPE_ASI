package com.sp.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
	public Optional<Card> getCard(int id) {
		return cRepo.findById(id);
	}
	
	/**
	 * @param
	 * @return les cartes
	 */
	public Set<Card> getCards() {
		return (Set<Card>) cRepo.findAll();
	}
	
	/*
	 * public Boolean doesExist(int id) { return true; }
	 */
	
	/**
	 * 
	 * @param card 
	 */
	/*
	 * public void addCard(Card card) {
	 * 
	 * }
	 */
	
	
	
}