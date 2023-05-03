package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.service.CardService;

@Service
public class BuySellService{
	
	@Autowired
	private CardService cService;
	@Autowired
	private UserService uService;
	
	
	public boolean buyCard(int idc, int idu) {
		
		Card card = cService.getCard(idc);
		int price = card.getPrice();

		if(price > uService.getUser(idu).getMoney()) {
			return false;
		}
		else {
			uService.buyCard(card);
			return true;
		}
		
		return false;
		
	}
	
	public void sellCard(int idc) {
		uService.sellCard(card);
	}
}