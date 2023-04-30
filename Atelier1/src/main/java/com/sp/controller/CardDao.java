package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.Affinity;
import com.sp.model.Family;

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
  
		Card c1=new Card("Valentin", "Super rageux", Family.Bird, "https://media.licdn.com/dms/image/D4E35AQGR_g45-rbTHQ/profile-framedphoto-shrink_800_800/0/1673625928639?e=1683396000&v=beta&t=1xWvi7orexwufQU0WXIUkEZVg2DyPA5ioLu20-oLVNw",Affinity.Electric, 50, 80, 35, 15);
		Card c2=new Card("Maxime", "Super aigri", Family.Ocean, "https://media.licdn.com/dms/image/C4D03AQFjR9ZCw-UFrA/profile-displayphoto-shrink_800_800/0/1636232497012?e=1687996800&v=beta&t=FZ5nI4ddSpZT0W0b-jK72-uTf07KML-u8xawZ7RTnZc",Affinity.Water,15,96,38,12);
		Card c3=new Card("Paul", "Super en retard", Family.Tree, "https://media.licdn.com/dms/image/C4E03AQHBpqnSh9Oscg/profile-displayphoto-shrink_800_800/0/1636807627629?e=1687996800&v=beta&t=4VILGugCjb-HF3x0hvqehfB2zV6519mVaEAU9r6EVbU", Affinity.Plant, 15,7,69,98);
		Card c4=new Card("Rodolphe", "Super perdu", Family.Ocean, "https://media.licdn.com/dms/image/C4E03AQEBev7wpACXYg/profile-displayphoto-shrink_800_800/0/1638295625757?e=1687996800&v=beta&t=XfF4rbtC3_Ir-q8DV2nMtNcD9rVizjTlQ-bgO3woKls",Affinity.Poison, 23,54,6,47);
		

		myCardList.add(c1);
		myCardList.add(c2);
		myCardList.add(c3);
		myCardList.add(c4);
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

	public Card addCard(String name, String description, Family family, String imgUrl, Affinity affinity, int hp, int energy, int attack, int defence) {
		Card p=new Card(name, description, family, imgUrl, affinity, hp, energy, attack, defence);
		this.myCardList.add(p);
		return p;
	}
}
