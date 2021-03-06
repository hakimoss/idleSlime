package com.hakim.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;




public class Enemi extends Personnages{

	private Image imgEnemi;
	private ImageIcon icoEnemi;
	private int health;
	private int dmg;
	private int goldValue;
	
	public Enemi(int x, int y) {
		super(x, y, 25, 32);
		super.setVersDroite(false);
		super.setMarche(true);
		
		icoEnemi = new ImageIcon(getClass().getResource("/images/oeil3Mort.png"));
		imgEnemi = icoEnemi.getImage();
		
		this.health = 3;
		this.dmg = 1;
		this.goldValue = 3;
	
	}

	//   GETTERS   //
	public Image getImgEnemi() {return imgEnemi;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public int getGoldValue() {return goldValue;}

	
	//   SETTERS   //
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}
	
	public void setGoldValue(int goldValue) {this.goldValue = goldValue;}
	
	//   METHODS   //

	

	
	





	

}
