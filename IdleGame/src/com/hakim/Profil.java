package com.hakim;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Profil implements Serializable {
	private int id;
	private String email;
	private String password;
	private String name;
	private int stage;
	private int dmg;
	private int health;
	private int gold;
	
	
	//   GETTERS   //
	public int getId() {return id;}
	
	public String getEmail() {return email;}
	
	public String getPassword() {return password;}
	
	public String getName() {return name;}
	
	public int getStage() {return stage;}

	public int getDmg() {return dmg;}
	
	public int getHealth() {return health;}
	
	public int getGold() {return gold;}

	//   SETTERS   //
	public void setId(int id) {this.id = id;}
	
	public void setEmail(String email) {this.email = email;}
	
	public void setPassword(String password) {this.password = password;}
	
	public void setName(String name) {this.name = name;}
	
	public void setStage(int stage) {this.stage = stage;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}
	
	public void setHealth(int health) {this.health = health;}
	
	public void setGold(int gold) {this.gold = gold;}

	Profil() {
		super();
	}
	
	public Profil(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public Profil(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	
	}
	
}
