package com.hakim.gameplay;

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
					int upperbound = 100;
			        //generate random values from 0-99
					int int_random = rand.nextInt(upperbound); 
					System.out.println("nombre randome entre 0-99 : "+int_random);
					
					int slotNb = 0;
					while(this.hero.itemInInventory[slotNb].name != "" && slotNb < 9) {
						slotNb++;
					}
					if(int_random <= 49) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							this.hero.itemInInventory[slotNb].name = "P";
						}
					} else if(int_random >50) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgWhite = new RuneDmg("white");
							//this.hero.itemInInventory[slotNb] = runeDmgWhite;
							this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
							this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
							this.hero.itemInInventory[slotNb].dmg = runeDmgWhite.dmg;
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
