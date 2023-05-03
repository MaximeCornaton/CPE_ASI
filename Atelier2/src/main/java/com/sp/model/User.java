/**
 * 
 */
package com.sp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

}
