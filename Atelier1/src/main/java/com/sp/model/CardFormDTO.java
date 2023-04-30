package com.sp.model;

public class CardFormDTO  {

	private String name;
	private String description;
	private Family family;
	private String imgUrl;
	private Affinity affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defence;

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public CardFormDTO() {
		this.name = "";
		this.description = "";
		this.family = Family.Bird;
		this.imgUrl="";
		this.affinity=Affinity.Fire;
		this.hp=0;
		this.energy=0;
		this.attack=0;
		this.defence=0;
	}

	public CardFormDTO(String name,String description,Family family, String imgUrl, Affinity affinity, int hp, int energy, int attack, int defence) {
		this.name = name;
		this.description = description;
		this.family = family;
		this.imgUrl=imgUrl;
		this.affinity = affinity;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
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
	
}
