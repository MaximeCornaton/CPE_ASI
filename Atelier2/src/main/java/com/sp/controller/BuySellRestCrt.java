  package com.sp.controller;

  import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

import com.sp.model.CardPurchaseRequest;
import com.sp.service.BuySellService;
  
  @RestController
  public class BuySellRestCrt{
	  @Autowired
	  BuySellService bsService;
	  
	  @RequestMapping(method=RequestMethod.POST, value="/buy")
	  public void buyCard(@RequestBody CardPurchaseRequest cardPurchaseRequest) {
	    int idc = cardPurchaseRequest.getIdc();
	    int idu = cardPurchaseRequest.getIdu();
		bsService.buyCard(idc, idu);
	  }
	  
	  @RequestMapping(method=RequestMethod.POST, value="/sell")
	  public void sellCard(@RequestBody CardPurchaseRequest cardPurchaseRequest) {
	    int idc = cardPurchaseRequest.getIdc();
	    int idu = cardPurchaseRequest.getIdu();
		bsService.sellCard(idc, idu);
	  }
	  
  }