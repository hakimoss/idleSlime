package com.hakim.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.hakim.Main;

public class Hero extends Personnages {
	
	private Image imgHero;
	private ImageIcon icoHero;
	
	private boolean libre;

	public Hero(int x, int y) {
		super(x, y, 60, 49);
		
		this.icoHero = new ImageIcon(getClass().getResource("/images/hero1Droite.png"));
		this.imgHero = this.icoHero.getImage();
		this.libre = true;
		
	}

	
	//   GETTERS   //
	public Image getImgHero() {return imgHero;}
	
	public boolean isLibre() {return libre;}

	//   SETTERS   //
	public void setLibre(boolean libre) {this.libre = libre;}


	//   METHODS   //
	public void contact(Personnages personnage) {
		if(personnage.isVivant() == true) {
			if(super.contactAvant(personnage) == true || super.contactArriere(personnage) ==  true ) {
				Main.scene.setDx(0);
				this.libre = false;
				this.setMarche(false);
			} 
		}
		
	}
	
}
