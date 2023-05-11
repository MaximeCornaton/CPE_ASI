package com.sp.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer>{

	Optional<Card> findByidCard(int id);
	
	@Query(value = "SELECT * FROM T_CARD WHERE id NOT IN ( SELECT card_id FROM TJ_USER_CARD ) ", nativeQuery = true)
	Set<Card> getCardBuyable();
	
	/* public Card findbyId(int id); */
	
	
}
