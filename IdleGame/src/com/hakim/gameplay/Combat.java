package com.hakim.gameplay;

import com.hakim.Main;
import com.hakim.item.Potion;
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
			Random rand = new Random(); //instance of random class
			try {
				
				Thread.sleep(1000);
				int critChanceNb = 100;
		        //generate random values from 0-999
				int critChance = rand.nextInt(critChanceNb); 
				double critDmg = (this.hero.getDmg()*(200+this.hero.getCritDmg()))/100;
				if(this.hero.getDefence()>=this.personnage.getDmg()) {
					if(this.hero.getCritChance() >= (critChance + 1)) {
						this.personnage.setHealth(this.personnage.getHealth() - (int) critDmg);
					} else {
						this.personnage.setHealth(this.personnage.getHealth() - this.hero.getDmg());
					}
				} else {
					if(this.hero.getCritChance() >= (critChance + 1)) {
						this.personnage.setHealth(this.personnage.getHealth() - (int) critDmg);
						this.hero.setHealth(this.hero.getHealth() - (this.personnage.getDmg() - this.hero.getDefence()));
					} else {
						this.personnage.setHealth(this.personnage.getHealth() - this.hero.getDmg());
						this.hero.setHealth(this.hero.getHealth() - (this.personnage.getDmg() - this.hero.getDefence()));
					}
				}

				if(this.hero.getHealth() <= 0) {
					this.hero.setVivant(false);
				} else if (this.personnage.getHealth() <= 0) {
					this.hero.setGold(this.hero.getGold() + personnage.getGoldValue());
					this.personnage.setVivant(false);
					this.hero.setEnCombat(false);
					
					
					int upperbound = 1000;
			        //generate random values from 0-999
					int int_random = rand.nextInt(upperbound); 
					System.out.println("nombre randome entre 0-999 : "+int_random);
					
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
								Potion potionWhite = new Potion("white");
								this.hero.itemInInventory[slotNb].name = potionWhite.name;
								this.hero.itemInInventory[slotNb].stats1 = potionWhite.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = potionWhite.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = potionWhite.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = potionWhite.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = potionWhite.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = potionWhite.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = potionWhite.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = potionWhite.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = potionWhite.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = potionWhite.stats5Value;
							} else if(potionRand > 11 && potionRand <= 20 && Main.scene.stage >= 5) {
								Potion potionGreen = new Potion("green");
								this.hero.itemInInventory[slotNb].name = potionGreen.name;
								this.hero.itemInInventory[slotNb].stats1 = potionGreen.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = potionGreen.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = potionGreen.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = potionGreen.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = potionGreen.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = potionGreen.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = potionGreen.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = potionGreen.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = potionGreen.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = potionGreen.stats5Value;
							} else if(potionRand > 21 && potionRand <= 30 && Main.scene.stage >= 10) {
								Potion potionBlue = new Potion("blue");
								this.hero.itemInInventory[slotNb].name = potionBlue.name;
								this.hero.itemInInventory[slotNb].stats1 = potionBlue.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = potionBlue.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = potionBlue.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = potionBlue.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = potionBlue.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = potionBlue.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = potionBlue.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = potionBlue.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = potionBlue.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = potionBlue.stats5Value;
							} else if(potionRand > 31 && potionRand <= 40 && Main.scene.stage >= 15) {
								Potion potionPurple = new Potion("purple");
								this.hero.itemInInventory[slotNb].name = potionPurple.name;
								this.hero.itemInInventory[slotNb].stats1 = potionPurple.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = potionPurple.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = potionPurple.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = potionPurple.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = potionPurple.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = potionPurple.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = potionPurple.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = potionPurple.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = potionPurple.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = potionPurple.stats5Value;
							} else if(potionRand > 41 && potionRand <= 50 && Main.scene.stage >= 20) {
								Potion potionOrange = new Potion("orange");
								this.hero.itemInInventory[slotNb].name = potionOrange.name;
								this.hero.itemInInventory[slotNb].stats1 = potionOrange.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = potionOrange.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = potionOrange.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = potionOrange.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = potionOrange.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = potionOrange.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = potionOrange.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = potionOrange.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = potionOrange.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = potionOrange.stats5Value;
							}
						}
					} else if(int_random >101 && int_random < 150) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgWhite = new RuneDmg("white");
							if(runeDmgWhite.stats1 == "A") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgWhite.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgWhite.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgWhite.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgWhite.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgWhite.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgWhite.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgWhite.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgWhite.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgWhite.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgWhite.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
								//this.hero.itemInInventory[slotNb] = runeDmgWhite;
								//Main.scene.hero.setDmg(Main.scene.hero.getDmg() + Main.scene.hero.itemInInventory[slotNb].stats1Value);
								System.out.println("dmg : "+this.hero.itemInInventory[slotNb].stats1);
							} else if(runeDmgWhite.stats1 == "C") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgWhite.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgWhite.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgWhite.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgWhite.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgWhite.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgWhite.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgWhite.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgWhite.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgWhite.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgWhite.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
								//this.hero.itemInInventory[slotNb] = runeDmgWhite;
								//Main.scene.hero.setCritChance(Main.scene.hero.getCritChance() + Main.scene.hero.itemInInventory[slotNb].stats1Value);
								System.out.println("critCHance : "+this.hero.itemInInventory[slotNb].stats1);
							} else if(runeDmgWhite.stats1 == "I") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgWhite.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgWhite.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgWhite.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgWhite.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgWhite.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgWhite.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgWhite.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgWhite.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgWhite.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgWhite.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
								//this.hero.itemInInventory[slotNb] = runeDmgWhite;
								//Main.scene.hero.setCritDmg(Main.scene.hero.getCritDmg() + Main.scene.hero.itemInInventory[slotNb].stats1Value);
								System.out.println("critDmg : "+this.hero.itemInInventory[slotNb].stats1);
							}
							//this.hero.itemInInventory[slotNb].name = runeDmgWhite.name;
							//this.hero.itemInInventory[slotNb].rarity = runeDmgWhite.rarity;
							//this.hero.itemInInventory[slotNb].dmg = runeDmgWhite.dmg;
							
						}
					} else if(int_random >= 151 && int_random < 190 && Main.scene.stage >= 5) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgGreen = new RuneDmg("green");
							if(runeDmgGreen.stats1 == "A") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgGreen.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgGreen.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgGreen.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgGreen.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgGreen.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgGreen.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgGreen.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgGreen.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgGreen.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgGreen.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgGreen.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgGreen.rarity;
							} else if(runeDmgGreen.stats1 == "C") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgGreen.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgGreen.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgGreen.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgGreen.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgGreen.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgGreen.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgGreen.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgGreen.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgGreen.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgGreen.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgGreen.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgGreen.rarity;
							} else if(runeDmgGreen.stats1 == "I") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgGreen.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgGreen.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgGreen.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgGreen.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgGreen.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgGreen.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgGreen.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgGreen.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgGreen.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgGreen.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgGreen.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgGreen.rarity;
							}
						}
					} else if(int_random >= 191 && int_random < 220 && Main.scene.stage >= 10) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgBlue = new RuneDmg("blue");
							if(runeDmgBlue.stats1 == "A") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgBlue.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgBlue.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgBlue.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgBlue.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgBlue.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgBlue.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgBlue.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgBlue.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgBlue.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgBlue.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgBlue.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgBlue.rarity;
							} else if(runeDmgBlue.stats1 == "C") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgBlue.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgBlue.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgBlue.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgBlue.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgBlue.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgBlue.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgBlue.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgBlue.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgBlue.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgBlue.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgBlue.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgBlue.rarity;
							} else if(runeDmgBlue.stats1 == "I") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgBlue.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgBlue.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgBlue.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgBlue.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgBlue.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgBlue.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgBlue.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgBlue.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgBlue.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgBlue.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgBlue.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgBlue.rarity;
							}
						}
					} else if(int_random >= 221 && int_random < 230 && Main.scene.stage >= 15) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgPurple = new RuneDmg("purple");
							if(runeDmgPurple.stats1 == "A") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgPurple.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgPurple.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgPurple.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgPurple.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgPurple.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgPurple.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgPurple.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgPurple.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgPurple.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgPurple.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgPurple.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgPurple.rarity;
							} else if(runeDmgPurple.stats1 == "C") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgPurple.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgPurple.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgPurple.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgPurple.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgPurple.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgPurple.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgPurple.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgPurple.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgPurple.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgPurple.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgPurple.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgPurple.rarity;
							} else if(runeDmgPurple.stats1 == "I") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgPurple.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgPurple.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgPurple.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgPurple.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgPurple.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgPurple.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgPurple.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgPurple.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgPurple.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgPurple.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgPurple.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgPurple.rarity;
							}
						}
					} else if(int_random == 231  && Main.scene.stage >= 20) {
						if(this.hero.itemInInventory[slotNb].name == "") {
							RuneDmg runeDmgOrange = new RuneDmg("orange");
							if(runeDmgOrange.stats1 == "A") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgOrange.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgOrange.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgOrange.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgOrange.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgOrange.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgOrange.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgOrange.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgOrange.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgOrange.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgOrange.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgOrange.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgOrange.rarity;
							} else if(runeDmgOrange.stats1 == "C") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgOrange.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgOrange.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgOrange.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgOrange.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgOrange.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgOrange.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgOrange.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgOrange.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgOrange.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgOrange.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgOrange.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgOrange.rarity;
							} else if(runeDmgOrange.stats1 == "I") {
								this.hero.itemInInventory[slotNb].stats1 = runeDmgOrange.stats1;
								this.hero.itemInInventory[slotNb].stats1Value = runeDmgOrange.stats1Value;
								this.hero.itemInInventory[slotNb].stats2 = runeDmgOrange.stats2;
								this.hero.itemInInventory[slotNb].stats2Value = runeDmgOrange.stats2Value;
								this.hero.itemInInventory[slotNb].stats3 = runeDmgOrange.stats3;
								this.hero.itemInInventory[slotNb].stats3Value = runeDmgOrange.stats3Value;
								this.hero.itemInInventory[slotNb].stats4 = runeDmgOrange.stats4;
								this.hero.itemInInventory[slotNb].stats4Value = runeDmgOrange.stats4Value;
								this.hero.itemInInventory[slotNb].stats5 = runeDmgOrange.stats5;
								this.hero.itemInInventory[slotNb].stats5Value = runeDmgOrange.stats5Value;
								
								this.hero.itemInInventory[slotNb].name = runeDmgOrange.name;
								this.hero.itemInInventory[slotNb].rarity = runeDmgOrange.rarity;
							}
						}
					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}



	
	
	
}
