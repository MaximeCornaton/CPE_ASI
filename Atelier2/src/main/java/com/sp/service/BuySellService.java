package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.CardService;

@Service
public class BuySellService{
	
	@Autowired
	private CardService cService;
	@Autowired
	private UserService uService;
	
	/**
	 * 
	 * @param idc
	 * @param idu
	 * @return True if the card is bought false otherwise
	 */
	public boolean buyCard(int idc, int idu) {
		
		Card card = cService.getCard(idc);
		User user = uService.getUser(idu);
		int price = card.getPrice();

		if(price > uService.getUser(idu).getMoney()) {
			return false;
		}
		else {
			card.setUser(user);
			uService.buyCard(card,idu);
			user.setMoney(user.getMoney()-price);
			
			uService.updateUser(user);
			cService.updateCard(card);
			
			return true;
		}		
	}
	
	/**
	 * 
	 * @param idc
	 * @param idu
	 */
	public void sellCard(int idc, int idu) {
		
		User user = uService.getUser(idu);
		Card card = cService.getCard(idc);
		int price = card.getPrice();
		
		user.setMoney(user.getMoney()+price);
		uService.sellCard(card, idc);
		card.setUser(null);
		
		cService.updateCard(card);
		uService.updateUser(user);
	}
}