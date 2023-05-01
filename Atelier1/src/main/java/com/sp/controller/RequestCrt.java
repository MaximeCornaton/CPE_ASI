  package com.sp.controller;

  /*import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;*/

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.beans.factory.annotation.Value;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.model.Card;
import com.sp.model.CardFormDTO;
//import com.sp.model.Family;
  
  @Controller // AND NOT @RestController
  public class RequestCrt {
  
    @Autowired
    CardDao CardDao;

  	@Value("${welcome.message}")
  	private String message;
  
  	private static String messageLocal="Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
  
  	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  	public String index(Model model) {
    
  		model.addAttribute("message", message);
  		model.addAttribute("messageLocal", messageLocal);
  
  		return "index";
  		
  	}
  	
  	@RequestMapping(value = { "/card"}, method = RequestMethod.GET)
    public String view(Model model) {
    model.addAttribute("myCard",CardDao.getRandomCard());
      return "CardView";
  }
 
    @RequestMapping(value = { "/addCard"}, method = RequestMethod.GET)
      public String addcard(Model model) {
      	CardFormDTO cardForm = new CardFormDTO();
      	model.addAttribute("cardForm", cardForm);
      	return "cardForm";
      }

	@RequestMapping(value = { "/addCard"}, method = RequestMethod.POST)
	public String addcard(Model model, @ModelAttribute("cardForm") CardFormDTO cardForm) {
		Card c=CardDao.addCard(cardForm.getName(),cardForm.getDescription(),cardForm.getFamily(),cardForm.getImgUrl(), cardForm.getAffinity(), cardForm.getHp(), cardForm.getEnergy(), cardForm.getAttack(), cardForm.getDefence());
		model.addAttribute("myCard",c );
		return "cardView";
	}
	
	@RequestMapping(value = { "/list"}, method = RequestMethod.GET)
    public String viewList(Model model) {
  	  model.addAttribute("CardList",CardDao.getCardList() );
  	  return "CardViewList";
    }

	
  }
  
  
  