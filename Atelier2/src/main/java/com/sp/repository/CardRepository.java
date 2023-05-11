package com.sp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface CardRepository extends CrudRepository<Card, Integer>{

	Optional<Card> findByidCard(int id);
	
	/* public Card findbyId(int id); */
	
	
}
