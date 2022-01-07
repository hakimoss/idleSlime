package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Flamme extends Personnages {
	
	private Image imgFlamme;
	private ImageIcon icoFlamme;
	private int health;
	private int dmg;
	private int goldValue;
	
	public Flamme(int x, int y) {
		super(x, y, 64, 64);
		super.setVersDroite(false);
		super.setMarche(true);
		
		icoFlamme = new ImageIcon(getClass().getResource("/images/flamme1Gauche.png"));
		imgFlamme = icoFlamme.getImage();
		
		this.health = 3;
		this.dmg = 1;
		this.goldValue = 3;
	
	}

	//   GETTERS   //
	public Image getImgFlamme() {return imgFlamme;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public int getGoldValue() {return goldValue;}

	
	//   SETTERS   //
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}
	
	public void setGoldValue(int goldValue) {this.goldValue = goldValue;}
	
	//   METHODS   //

	


}
