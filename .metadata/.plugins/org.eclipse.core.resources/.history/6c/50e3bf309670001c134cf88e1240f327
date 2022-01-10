package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.Main;
import com.hakim.Profil;
import com.hakim.gameplay.Combat;

public class Hero extends Personnages {
	
	private Image imgHero;
	private ImageIcon icoHero;
	
	private String playerName;
	private long lastUpdate;
	
	private int health;
	private int healthLvl;
	private int dmg;
	private int gold;
	private int dmgPrice;
	private int stageMax;
	private String email;
	private String selectedHero;
	private Profil profil;
	
	
	private boolean libre;
	private boolean enCombat;

	public Hero(int x, int y) {
		super(x, y, 60, 49);
		
		this.icoHero = new ImageIcon(getClass().getResource("/images/hero1Droite.png"));
		this.imgHero = this.icoHero.getImage();
		this.libre = true;
		
		this.healthLvl = 1;
		this.health = 100;
		this.dmg = 2;
		this.enCombat = false;
		this.gold = 0;
		this.dmgPrice = this.dmg*10;
		this.stageMax = 0;
		this.email = null;
		this.playerName = null;
		this.selectedHero = null;
	
	}
	

	public Profil getProfil() {return profil;}


	public void setProfil(Profil profil) {this.profil = profil;}


	//   GETTERS   //
	public Image getImgHero() {return imgHero;}
	
	public boolean isLibre() {return libre;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public boolean isEnCombat() {return enCombat;}
	
	public int getGold() {return gold;}
	
	public int getDmgPrice() {return dmgPrice;}

	public int getHealthLvl() {return healthLvl;}

	public int getStageMax() {return stageMax;}

	public String getEmail() {return email;}
	
	public String getPlayerName() {return playerName;}
	
	public long getLastUpdate() {return lastUpdate;}
	
	public String getSelectedHero() {return selectedHero;}
	
	//   SETTERS   //
	public void setLibre(boolean libre) {this.libre = libre;}
	
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}

	public void setEnCombat(boolean enCombat) {this.enCombat = enCombat;}
	
	public void setGold(int gold) {this.gold = gold;}

	public void setDmgPrice(int dmgPrice) {this.dmgPrice = dmgPrice;}

	public void setHealthLvl(int healthLvl) {this.healthLvl = healthLvl;}
	
	public void setStageMax(int stageMax) {this.stageMax = stageMax;}

	public void setEmail(String email) {this.email = email;}
	
	public void setPlayerName(String playerName) {this.playerName = playerName;}
	
	public void setLastUpdate(long lastUpdate) {this.lastUpdate = lastUpdate;}
	
	public void setSelectedHero(String selectedHero) {this.selectedHero = selectedHero;}

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
