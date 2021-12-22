package com.hakim;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hakim.personnages.Enemi;
import com.hakim.personnages.Hero;

import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	private ImageIcon icoFond1;
	private Image imgFond1;
	private Image imgFond2;
	
	private Hero hero;
	private Enemi enemi;
	//private ImageIcon icoEnemi;
	//private Image imgEnemi;
	
	//private ImageIcon icoHero;
	//private Image imgHero;
	
	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;
	private int ySol;

	
	public Scene() {
		super();
		
		this.xFond1 = 0;
		this.xFond2 = 800;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 326;/// pas déterminer
		
		icoFond1 = new ImageIcon(getClass().getResource("/images/stageForest.png"));
		imgFond1 = icoFond1.getImage();
		imgFond2 = icoFond1.getImage();
		
		//icoEnemi = new ImageIcon(getClass().getResource("/images/enemi1Gauche.png"));
		//imgEnemi = icoEnemi.getImage();
		
		hero=new Hero(50, 183);
		enemi=new Enemi(100, 198);
		
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		Thread chronoEcran=new Thread(new Chrono());
		chronoEcran.start();
	}

	//   GETTERS   //
	public int getDx() {return dx;}

	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	//   SETTERS   //
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	//public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}
	
	//  METHODS   //
	public void deplacementFond() {
		
		if(this.xPos >= 0 && this.xPos <= 2700) {
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		if(this.xFond1 == 0) {this.xFond2 = 800;} 
		if(this.xFond2 == 0) {this.xFond1 = 800;}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		
		//contact
		if(this.hero.proche(this.enemi)) {
			this.hero.contact(this.enemi);
			if(this.enemi.isVivant() == false) {
				this.hero.setLibre(true);
			}
		
		}
		
		if(this.enemi.proche(this.hero)) {
			this.enemi.contact(this.hero);
		}

		if(this.xPos == -1) {
			this.xPos = 0;
			this.xFond1 = 0;
			this.xFond2 = 800;
		
		}
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 2700) {
			this.enemi.deplacement();
		}
		
		if(this.hero.isLibre() == true) {
			this.hero.setMarche(true);
			this.setDx(1);
		} else {
			this.hero.setMarche(false);
			this.setDx(0);
		}
		
		
		
		
		
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		g2.drawImage(this.hero.marche("hero", 80), 50, 183, null);
		
		g2.drawImage(this.enemi.marche("enemi", 100), 150 - this.xPos, 197, null);
		
		
	}
	
}
