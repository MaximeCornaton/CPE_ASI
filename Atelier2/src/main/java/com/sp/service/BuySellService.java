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

		if(price > user.getMoney()) {
			return false;
		}
		else {
			if (user.getCardList().contains(card)) {
				throw new RuntimeException("User already owns this card");
			}
			uService.buyCard(card,user);
			user.setMoney(user.getMoney()-price);
			
			uService.updateUser(user);
			
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
		uService.sellCard(card, user);
		
		uService.updateUser(user);
	}
}