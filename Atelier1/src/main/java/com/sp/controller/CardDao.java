package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sp.model.Card;

@Service
public class CardDao {
	private List<Card> myCardList;
	private Random randomGenerator;

	public CardDao() {
		myCardList=new ArrayList<>();
		randomGenerator = new Random();
		createCardList();
	}

	private void createCardList() {
  
		Card c1=new Card("John", "British hero", "super pink", "http://ekladata.com/9-cPSlYvrenNHMVawFmf_gLx8Jw.gif","Royal family");
		Card c2=new Card("Roberto", "Spannish hero", "super lazy", "http://ekladata.com/JEVyY9DkwX4vVkakeBfikSyPROA.gif","Feu");
		Card c3=new Card("Anna", "French hero", "super music girl", "http://ekladata.com/fMJl--_v-3CmisaynTHju1DMeXE.gif", "Terre");
		Card c4=new Card("Angry Joe", "American hero", "super angry power", "http://ekladata.com/AmbNNNvv-4YFEMZR8XD8e54WoHc.gif","Ocean");
		Card c5=new Card("Ursula", "Australian hero", "super cloning power", "http://ekladata.com/CXJhi2YLUbNz6__e0Ct6ZP-XOds.gif","air");

		myCardList.add(c1);
		myCardList.add(c2);
		myCardList.add(c3);
		myCardList.add(c4);
		myCardList.add(c5);
	}
	public List<Card> getCardList() {
		return this.myCardList;
	}
	public Card getCardByName(String name){
		Card res = null;
		for (Card CardBean : myCardList) {
			if(CardBean.getName().equals(name)){
				res = CardBean;
			}
		}
		return res;
	}
	public Card getRandomCard(){
		int index=randomGenerator.nextInt(this.myCardList.size());
		return this.myCardList.get(index);
	}

	public Card addCard(String name, String description, String family, String imgUrl, String affinity) {
		Card p=new Card(name, description, family, imgUrl, affinity);
		this.myCardList.add(p);
		return p;
	}
}
