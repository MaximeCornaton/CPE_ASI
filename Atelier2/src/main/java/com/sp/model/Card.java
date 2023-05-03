/**
 * 
 */
package com.sp.model;

/**
 * @author maxime
 *
 */
public class Card {
	
	private int id; 
	private String name;
	private String description;
	private String imgUrl;
	private Family family;
	private Affinity affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defence;
	private int prix;
	

	
	public Card(String name,String description,String imgUrl, Family family, Affinity affinity, int hp, int energy, int attack, int defence, int prix) {
		this.name = name;
		this.description = description;
		this.imgUrl= imgUrl;
		this.family = family;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.prix = prix;
	}
	
	
	public Card() {
		this("", "", "", Family.Bird, Affinity.Wind, 0, 0, 0, 0, 0);
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}


	/**
	 * @param imgUrl the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	/**
	 * @return the family
	 */
	public Family getFamily() {
		return family;
	}


	/**
	 * @param family the family to set
	 */
	public void setFamily(Family family) {
		this.family = family;
	}


	/**
	 * @return the affinity
	 */
	public Affinity getAffinity() {
		return affinity;
	}


	/**
	 * @param affinity the affinity to set
	 */
	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}


	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}


	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}


	/**
	 * @return the energy
	 */
	public int getEnergy() {
		return energy;
	}


	/**
	 * @param energy the energy to set
	 */
	public void setEnergy(int energy) {
		this.energy = energy;
	}


	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}


	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}


	/**
	 * @return the defence
	 */
	public int getDefence() {
		return defence;
	}


	/**
	 * @param defence the defence to set
	 */
	public void setDefence(int defence) {
		this.defence = defence;
	}


	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}


	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

}
