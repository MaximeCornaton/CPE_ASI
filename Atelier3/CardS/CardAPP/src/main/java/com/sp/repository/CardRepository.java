package com.sp.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer>{

	Optional<Card> findByidCard(int id);
	

	
	@Query("SELECT c FROM Card c WHERE c.idCard NOT IN (SELECT DISTINCT card.idCard FROM User u JOIN u.cardList card)")
    Set<Card> getCardBuyable();
	
	/* public Card findbyId(int id); */
	
	
}
