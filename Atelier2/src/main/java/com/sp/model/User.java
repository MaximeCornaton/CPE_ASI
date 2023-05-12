/**
 * 
 */
package com.sp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author paulaubry
 *
 */
@Entity @Table(name="T_USER")
public class User {
	
	@Id
	@GeneratedValue
	private int idUser;
	private String name;
	private String surname;
	private String password;
	private int money;
	
	@JsonManagedReference
	@OneToMany
	@JoinTable( name = "TJ_USER_CARD",
				joinColumns = @JoinColumn(name = "idUser"),
				inverseJoinColumns = @JoinColumn(name="idCard"))
	private Set<Card> cardList;
	
	/**
	 * 
	 */
	public User() {
		
	}
		
	public void setCardList(Set<Card> cardList) {
		this.cardList = cardList;
	}

	public Set<Card> getCardList(){
		if(cardList == null) {
			cardList = new HashSet<Card>();
		}
		return cardList;
	}
	
	public void addCard(Card card) {
		this.cardList.add(card);
	}
	
	public void delCard(Card card) {
		this.cardList.remove(card);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return idUser;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.idUser = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", money=" + money + ", cardList=" + cardList + "]";
	}

}
