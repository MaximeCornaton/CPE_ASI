  package com.sp.controller;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.service.BuySellService;
  
  @RestController
  public class BuySellRestCrt{
	  @Autowired
	  BuySellService bsService;
	  
	  @RequestMapping(method=RequestMethod.POST, value="/buy")
	  public void buyCard(@RequestBody int idc, int idu) {
		  bsService.buyCard(idc, idu);
	  }
	  
	  @RequestMapping(method=RequestMethod.POST, value="/sell")
	  public void sellCard(@RequestBody int idc, int idu) {
		  bsService.sellCard(idc);
	  }
	  
  }