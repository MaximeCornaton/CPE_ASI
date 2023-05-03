package com.sp.repository;

import com.sp.model.Card;

public interface CardRepository{
	
	Card findbyId(int id);
	
	
}
