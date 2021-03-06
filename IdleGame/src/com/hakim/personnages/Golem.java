package com.hakim.personnages;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import com.hakim.gameplay.TimeListener;

public class Golem extends Personnages {

	private Image imgGolem;
	private ImageIcon icoGolem;

	private int health;
	private int dmg;
	private int goldValue;
	
	public Golem(int x, int y) {
		super(x, y, 71, 62);
		super.setVersDroite(false);
		super.setMarche(true);
		//this.dxEnemi = 1;
		
		icoGolem = new ImageIcon(getClass().getResource("/images/golem1Gauche.png"));
		imgGolem = icoGolem.getImage();
		
		this.health = 100;
		this.dmg = 5;
		this.goldValue = 100;
	
	}
	

	//   GETTERS   //
	public Image getImgGolem() {return imgGolem;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public int getGoldValue() {return goldValue;}

	
	//   SETTERS   //
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}
	
	public void setGoldValue(int goldValue) {this.goldValue = goldValue;}
	
	//   METHODS   //
	public Image marche(String nom, int frequence) {

		String str;
		ImageIcon ico;
		Image img;
		

		
		if(this.marche == false) {
			if(this.isVersDroite() == true) {
				str = "/images/"+nom+"1Droite.png";
			} else {
				str = "images/"+nom+"1Gauche.png";
			}		
		} else {
			ActionListener listener = new TimeListener();
			Timer timer = new Timer(1000, listener);
			timer.start();
			this.compteurMarche++;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
			if(this.compteurMarche >=4) {
				this.compteurMarche = 0;
			}
			if(this.isVersDroite() == true) {
				if(this.compteurMarche == 1) {
					str = "/images/"+nom+"2Droite.png";
				} else if(this.compteurMarche == 2) {
					str = "/images/"+nom+"3Droite.png";
				} else if(this.compteurMarche == 3) {
					str = "/images/"+nom+"4Droite.png";
				} else {
					str = "/images/"+nom+"1Droite.png";
				}
			} else {
				if(this.compteurMarche == 1) {
					str = "/images/"+nom+"2Gauche.png";
				} else if(this.compteurMarche == 2) {
					str = "/images/"+nom+"3Gauche.png";
				} else if(this.compteurMarche == 3) {
					str = "/images/"+nom+"4Gauche.png";
				} else {
					str = "/images/"+nom+"1Gauche.png";
				}
			}
			
		} 
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
		
	}
}
