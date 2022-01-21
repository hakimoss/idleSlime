package com.hakim.gameplay;

import com.hakim.Main;
import com.hakim.item.RuneDmg;
import com.hakim.personnages.Hero;
import com.hakim.personnages.Personnages;
import java.util.Random;

public class Combat implements Runnable {
	private Hero hero;
	public Personnages personnage;
	private int personnageHealth;
	
	public void combatEntrePersonnages(Hero hero, Personnages enemi) {
		this.personnage = enemi;
		this.hero = hero;
		this.hero.compteurCombat = 0;

		Thread chronoCombat= new Thread(this);
		
		if(this.hero.isVivant() == true && this.personnage.isVivant() == true) {
			chronoCombat.start();	
		} 
	}
	
	//   GETTERS   //
	public int getPersonnageHealth() {return personnageHealth;}

	//   SETTERS   //
	public void setPersonnageHealth(int personnageHealth) {this.personnageHealth = personnageHealth;}
	
	//   METHODS   //
	@Override
	public void run() {
	
	      
		while(this.hero.isEnCombat() == true) {	
			try {
				Thread.sleep(1000);
				this.hero.setHealth(this.hero.getHealth() - this.personnage.getDmg());
				this.personnage.setHealth(this.personnage.getHealth() - this.hero.getDmg());

				if(this.hero.getHealth() <= 0) {
					this.hero.setVivant(false);
				} else if (this.personnage.getHealth() <= 0) {
					this.hero.setGold(this.hero.getGold() + personnage.getGoldValue());
					this.personnage.setVivant(false);
					this.hero.setEnCombat(false);
					
					Random rand = new Random(); //instance of random class
					int upperbound = 1000;
			        //generate random values from 0-9999
					int int_random = rand.nextInt(upperbound); 
					System.out.println("nombre randome entre 0-9999 : "+int_random);
					
					int slotNb = 0;
					while(this.hero.itemInInventory[slotNb].name != "" && slotNb < 9) {
						slotNb++;
					}
					if(int_random <= 100) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							int upperbound2 = 100;
					        //generate random values from 0-99
							int potionRand = rand.nextInt(upperbound2); 
							System.out.println("nombre randome entre 0-9999 : "+potionRand);
							if(potionRand <= 10  || potionRand > 50) {
								this.hero.itemInInventory[slotNb].name = "PW";
							} else if(potionRand > 11 && potionRand <= 20 && Main.scene.stage >= 5) {
								this.hero.itemInInventory[slotNb].name = "PG";
							} else if(potionRand > 21 && potionRand <= 30 && Main.scene.stage >= 10) {
								this.hero.itemInInventory[slotNb].name = "PB";
							} else if(potionRand > 31 && potionRand <= 40 && Main.scene.stage >= 15) {
								this.hero.itemInInventory[slotNb].name = "PP";
							} else if(potionRand > 41 && potionRand <= 50 && Main.scene.stage >= 20) {
								this.hero.itemInInventory[slotNb].name = "PO";
							}
						}
					} else if(int_random >101 && int_random < 150) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgWhite = new RuneDmg("white");
							//this.hero.itemInInventory[slotNb] = runeDmgWhite;
							this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgWhite.dmg;
							System.out.println("dmg : "+this.hero.itemInInventory[slotNb].dmg);
						}
					} else if(int_random >= 151 && int_random < 190 && Main.scene.stage >= 5) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgGreen = new RuneDmg("green");
							this.hero.itemInInventory[slotNb].name = runeDmgGreen.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgGreen.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgGreen.dmg;
							System.out.println("dmg : "+this.hero.itemInInventory[slotNb].dmg);
						}
					} else if(int_random >= 191 && int_random < 220 && Main.scene.stage >= 10) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgBlue = new RuneDmg("blue");
							this.hero.itemInInventory[slotNb].name = runeDmgBlue.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgBlue.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgBlue.dmg;
							System.out.println("dmg : "+this.hero.itemInInventory[slotNb].dmg);
						}
					} else if(int_random >= 221 && int_random < 230 && Main.scene.stage >= 15) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgPurple = new RuneDmg("purple");
							this.hero.itemInInventory[slotNb].name = runeDmgPurple.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgPurple.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgPurple.dmg;
							System.out.println("dmg : "+this.hero.itemInInventory[slotNb].dmg);
						}
					} else if(int_random == 231  && Main.scene.stage >= 20) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgOrange = new RuneDmg("orange");
							this.hero.itemInInventory[slotNb].name = runeDmgOrange.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgOrange.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgOrange.dmg;
							System.out.println("dmg : "+this.hero.itemInInventory[slotNb].dmg);
						}
					}
	
	
	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}



	
	
	
}
