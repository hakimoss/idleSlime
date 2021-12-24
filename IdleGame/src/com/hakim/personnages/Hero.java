package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.Combat;
import com.hakim.Main;

public class Hero extends Personnages {
	
	private Image imgHero;
	private ImageIcon icoHero;
	
	private int health;
	private int dmg;
	private int gold;
	private int dmgPrice;
	
	private boolean libre;
	private boolean enCombat;

	public Hero(int x, int y) {
		super(x, y, 60, 49);
		
		this.icoHero = new ImageIcon(getClass().getResource("/images/hero1Droite.png"));
		this.imgHero = this.icoHero.getImage();
		this.libre = true;
		
		this.health = 100;
		this.dmg = 2;
		this.enCombat = false;
		this.gold = 100;
		this.dmgPrice = this.dmg*10;
		
	}






	public int getDmgPrice() {
		return dmgPrice;
	}






	public void setDmgPrice(int dmgPrice) {
		this.dmgPrice = dmgPrice;
	}

	//   GETTERS   //
	public Image getImgHero() {return imgHero;}
	
	public boolean isLibre() {return libre;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public boolean isEnCombat() {return enCombat;}
	
	public int getGold() {return gold;}


	//   SETTERS   //
	public void setLibre(boolean libre) {this.libre = libre;}
	
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}

	public void setEnCombat(boolean enCombat) {this.enCombat = enCombat;}
	
	public void setGold(int gold) {this.gold = gold;}


	//   METHODS   //
	public void contact(Personnages personnage) {
		if(personnage.isVivant() == true) {
			if(super.contactAvant(personnage) == true || super.contactArriere(personnage) ==  true ) {
				Main.scene.setDx(0);
				this.libre = false;
				this.setMarche(false);
				
			
				if(this.isEnCombat() == false) {
					Combat combat = new Combat();
					combat.combatEntrePersonnages(this, personnage);
					this.setEnCombat(true);
				}
				
				
			} 
		}
		
	}
	
	
	
	
	
}
