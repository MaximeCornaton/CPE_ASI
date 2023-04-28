package com.sp.model;
public class Card  {
	private String name;
	private String description;
	private String family;
	private String imgUrl;
	private String affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defence;

	public Card() {
		this.name = "";
		this.description = "";
		this.family = "";
		this.imgUrl="";
		this.affinity="";
		this.hp=10;
		this.energy=10;
		this.attack=10;
		this.defence=10;
		
	}
	public Card(String name,String description,String family, String imgUrl, String affinity) {
		this.name = name;
		this.description = description;
		this.family = family;
		this.imgUrl=imgUrl;
		this.affinity = affinity;
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
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}
	/**
	 * @param family the family to set
	 */
	public void setFamily(String family) {
		this.family = family;
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
	 * @return the affinity
	 */
	public String getAffinity() {
		return affinity;
	}
	/**
	 * @param affinity the affinity to set
	 */
	public void setAffinity(String affinity) {
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


}
