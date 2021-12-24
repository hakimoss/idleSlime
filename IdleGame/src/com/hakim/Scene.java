package com.hakim;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import com.hakim.personnages.Enemi;
import com.hakim.personnages.Hero;

import java.awt.Image;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	private ImageIcon icoFond1;
	private Image imgFond1;
	private Image imgFond2;
	
	private Image imgFondMenu;
	private ImageIcon icoFondMenu;
	
	
	
	public Hero hero;
	
	private ArrayList<Enemi> tabEnemi;
	private Enemi enemi, enemi2, enemi3, enemi4, enemi5, enemi6, enemi7, enemi8, enemi9, enemi10;

	
	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;
	private int yDmgString;
	private int ySol;
	
	
	/// MenuScne
	
	public JButton btnDmg;
	public JButton btnHealth;
	
	public Upgrade upgrade;

	
	public Scene() {
		super();
		
		this.xFond1 = 0;
		this.xFond2 = 800;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 326;/// pas déterminer
		this.yDmgString = 0;
		
		icoFond1 = new ImageIcon(getClass().getResource("/images/stageForest.png"));
		imgFond1 = icoFond1.getImage();
		imgFond2 = icoFond1.getImage();
		
		icoFondMenu = new ImageIcon(getClass().getResource("/images/fondMenuScene.png"));
		imgFondMenu = icoFondMenu.getImage();
		
		
		
		
		
		
		hero=new Hero(50, 183);
		
		enemi=new Enemi(150, 175);
		enemi2=new Enemi(200, 175);
		enemi3=new Enemi(300, 175);
		enemi4=new Enemi(400, 175);
		enemi5=new Enemi(500, 175);
		enemi6=new Enemi(550, 175);
		enemi7=new Enemi(590, 175);
		enemi8=new Enemi(620, 175);
		enemi9=new Enemi(690, 175);
		enemi10=new Enemi(720, 175);
		enemi3.setHealth(10);
		
		tabEnemi=new ArrayList<Enemi>();
		
		tabEnemi.add(enemi);
		tabEnemi.add(enemi2);
		tabEnemi.add(enemi3);
		tabEnemi.add(enemi4);
		tabEnemi.add(enemi5);
		tabEnemi.add(enemi6);
		tabEnemi.add(enemi7);
		tabEnemi.add(enemi8);
		tabEnemi.add(enemi9);
		tabEnemi.add(enemi10);
	
		
		/// MenuScene
		
		
		//this.add(btnDmg);
		//this.add(btnHealth);
				
		upgrade = new Upgrade(hero);
		this.setLayout(null);
		upgrade.btnDmg.setBounds(30, 500, 100, 20);
		this.add(upgrade.btnDmg);
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		Thread chronoEcran=new Thread(new Chrono());
		chronoEcran.start();
		
		
	}



	//   GETTERS   //
	public int getDx() {return dx;}

	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}
	
	public int getyDmgString() {return yDmgString;}

	//   SETTERS   //
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}
	
	public void setyDmgString(int yDmgString) {this.yDmgString = yDmgString;}

	//  METHODS   //
	public void deplacementFond() {

		if(this.xFond1 <= -800) {this.xFond1 = 800;} 
		else if(this.xFond2 <= -800) {this.xFond2 = 800;}
	
		if(this.xPos >= 0 && this.xPos <= 4000) {
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
	
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		this.deplacementFond();
		//contact entre le hero et les enemi
		for(int i = 0; i < tabEnemi.size(); i++) {
			if(this.hero.proche(this.tabEnemi.get(i))) {
				this.hero.contact(this.tabEnemi.get(i));
				if(this.tabEnemi.get(i).isVivant() == false) {
					this.hero.setLibre(true);
				}
			
			}
		}
		
		//mouvement du fond
		if(this.xPos == -1) {
			this.xPos = 0;
			this.xFond1 = 0;
			this.xFond2 = 800;
		
		}
		
		
		if(this.xPos >= 0 && this.xPos <= 4000) {
			for(int i = 0; i < tabEnemi.size(); i++) {
				this.tabEnemi.get(i).deplacement();
			}
			
		}
		
		if(this.hero.isLibre() == true) {
			this.hero.setMarche(true);
			this.setDx(3);
		} else {
			this.hero.setMarche(false);
			this.setDx(0);
		}

		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);

		for(int i = 0; i < this.tabEnemi.size(); i++) {
			g2.drawImage(this.tabEnemi.get(i).marche("oeil", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
		}
		
		if(this.hero.isEnCombat() == true) {
			g2.drawImage(this.hero.combatImg("hero", 200), 50, 183, null);
			for(int i = 0; i < tabEnemi.size(); i++) {
				if(this.hero.proche(this.tabEnemi.get(i)) == true && this.tabEnemi.get(i).isVivant() == true) {
					g2.drawString(""+this.tabEnemi.get(i).getHealth() , 135, 180);
				}
			}
		} else {
			g2.drawImage(this.hero.marche("hero", 100), 50, 183, null);
		}
		
		
		
		
		
		///    MENU SCENE    ///
		
		g2.drawImage(this.imgFondMenu, 0, 300, null);
		
		g2.drawString("Health : " + this.hero.getHealth() , 30, 330);
		
		g2.drawString("Damage : " + this.hero.getDmg(), 130, 330);
		
		g2.drawString("Gold : " + this.hero.getGold(), 230, 330);
		
		g2.drawString(this.hero.getDmg()*10+" Gold", 40, 490);
		
		
		
	}
	


	
	
}
