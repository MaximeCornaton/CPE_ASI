/**
 * 
 */
package com.sp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author paulaubry
 *
 */
@Entity @Table(name="T_USER")
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String surname;
	private String password;
	private int money;
	
	
	public User() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param password
	 * @param money
	 */
	public User(int id, String name, String surname, String password, int money) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.money = money;
	}

	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
		return "User [idUser=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password
				+ ", money=" + money + "]";
	}

}
