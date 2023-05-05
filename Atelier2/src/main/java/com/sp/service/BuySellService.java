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
			//Il faut aussi que la carte fasse du boulot de son coté
			
			uService.buyCard(card,idu);
			return true;
		}		
	}
	
	public void sellCard(int idc, int idu) {
		Card card = cService.getCard(idc);
		uService.sellCard(card, idc);
	}
}