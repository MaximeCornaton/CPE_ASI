package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.service.CardService;
import com.sp.service.UserService;

@Service
public class BuySellService{
	
	@Autowired
	private CardService cService;
	@Autowired
	private UserService uService;
	
	
	public void buyCard(int idc, int idu) {
		int price = cService.getCard(idc).getPrice();
		int userVault = uService.getArgent();
		if(price > userVault) {
			return;
		}
		
	}
	
	public void sellCard(int idc) {
		
	}
}