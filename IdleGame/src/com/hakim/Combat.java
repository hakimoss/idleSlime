package com.hakim;

import com.hakim.personnages.Hero;
import com.hakim.personnages.Personnages;

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
				
				
				System.out.println("enemie life : "+this.personnage.getHealth());
				System.out.println("hero life : "+this.hero.getHealth());
				Thread.sleep(1000);
				this.hero.setHealth(this.hero.getHealth() - this.personnage.getDmg());
				this.personnage.setHealth(this.personnage.getHealth() - this.hero.getDmg());
				
				
				
				if(this.hero.getHealth() <= 0) {
					this.hero.setVivant(false);
				} else if (this.personnage.getHealth() <= 0) {
					this.hero.setGold(this.hero.getGold() + personnage.getGoldValue());
					this.personnage.setVivant(false);
					this.hero.setEnCombat(false);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}



	
	
	
}