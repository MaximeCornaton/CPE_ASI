package com.sp.service;

import org.springframework.stereotype.Service;

@Service
public class CardService {
	
	public String addSuffix(String msg) {
		return msg +"\n"+ "Service processing";
	}
	
}