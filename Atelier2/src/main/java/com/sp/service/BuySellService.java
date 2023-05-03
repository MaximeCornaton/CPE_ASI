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
	
	
	public void buyCard(int idc, int idu) {
		Card card = cService.getCard(idc);
		int price = card.getPrice();
		int userVault = uService.getUser(idu).getMoney();

		if(price > userVault) {
			return;
		}
		else {
			uService.buyCard(card);
		}
		
	}
	
	public void sellCard(int idc) {
		int price = cService.getCard(idc).getPrice();
		uService.sellCard(card);
	}
}