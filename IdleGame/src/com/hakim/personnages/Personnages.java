package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.hakim.Main;
import com.hakim.TimeListener;

public class Personnages {
	
	private int largeur, hauteur;
	private int x, y;
	protected boolean marche;
	public int compteurMarche;
	public int compteurCombat;
	protected boolean vivant;
	protected boolean versDroite;
	
	protected int health;
	protected int dmg;
	protected int goldValue;
	
	
	
	public Personnages(int x, int y, int largeur, int hauteur) {
		
		this.x = x;
		this.y = y;
		this.largeur = largeur;	
		this.hauteur = hauteur;
		this.marche = true;
		this.compteurMarche = 0;
		this.compteurCombat = 0;
		this.vivant = true;
		this.versDroite = true;
		
		
		
		
	}

	


	//   GETTERS   //
	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}

	public int getX() {return x;}

	public int getY() {return y;}

	public boolean isMarche() {return marche;}

	public int getCompteurMarche() {return compteurMarche;}

	public boolean isVivant() {return vivant;}
	
	public boolean isVersDroite() {return versDroite;}
	
	public int getHealth() {return health;}
	
	public int getDmg() {return dmg;}
	
	public int getGoldValue() {return goldValue;}



	//   SETTERS   //
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setMarche(boolean marche) {this.marche = marche;}

	public void setCompteurMarche(int compteur) {this.compteurMarche = compteur;}

	public void setVivant(boolean vivant) {this.vivant = vivant;}
	
	public void setVersDroite(boolean versDroite) {this.versDroite = versDroite;}
	
	public void setHealth(int health) {this.health = health;}
	
	public void setDmg(int dmg) {this.dmg = dmg;}

	
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
			
			
		/*	
			try {
				Thread.sleep(frequence);
				this.compteurMarche++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		*/
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
	

	public Image combatImg(String nom, int frequence) {
		String str;
		Image img;
		ImageIcon ico;
		ActionListener listener = new TimeListener();
		Timer timer = new Timer(1000, listener);
		timer.start();
		this.compteurCombat++;
		System.out.println(this.compteurCombat);
		/*
		try {
			Thread.sleep(frequence);
			this.compteurCombat++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		if(this.compteurCombat >=5) {
			this.compteurCombat = 0;
		}
		
		if(this.compteurCombat == 4) {
			str = "/images/"+nom+"1Attaque.png";
		} else if(this.compteurCombat == 1) {
			str = "/images/"+nom+"4Attaque.png";
		} else {
			str = "/images/"+nom+"5Attaque.png";
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
		
	}

	public void deplacement() {
		if(Main.scene.getxPos() >= 0) {this.x = this.x - Main.scene.getDx();}
	}
	
	protected boolean contactAvant(Personnages personnage) {
		if(this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5 || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean contactArriere(Personnages personnage) {
		if(this.x > personnage.getX() + personnage.getLargeur() || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5 || this.y +this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean proche(Personnages personnage) {
		if((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getHauteur() + 10) || (this.x + this.largeur > personnage.getX() - 10 && this.x +this.largeur < personnage.getX() + personnage.getLargeur() + 10)) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
