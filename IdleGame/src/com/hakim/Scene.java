package com.hakim;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.font.TextAttribute;

import com.hakim.gameplay.Upgrade;
import com.hakim.logIn.LoginPanel;
import com.hakim.personnages.Enemi;
import com.hakim.personnages.Flamme;
import com.hakim.personnages.Golem;
import com.hakim.personnages.Hero;
import com.hakim.personnages.Personnages;

import java.awt.Image;
import java.text.AttributedString;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
@SuppressWarnings("serial")
public class Scene extends JPanel {

	private ImageIcon icoFond1;
	private Image imgFond1;
	private Image imgFond2;
	
	Image imgFondMenu;
	private ImageIcon icoFondMenu;

	public Hero hero;
	
	public ArrayList<Personnages> tabEnemi;
	private Enemi enemi, enemi2, enemi3, enemi4, enemi5, enemi6, enemi7, enemi8, enemi9, enemi10;
	private Flamme flamme, flamme2, flamme3, flamme4, flamme5, flamme6, flamme7, flamme8, flamme9, flamme10;
	
	public int stage;

	private int xFond1;
	private int xFond2;
	private int dx;
	private int xPos;
	private int yDmgString;
	
	private String inactiveTimeGain = "";
	
	private Golem golem;
	
	private boolean showGoldGainInactiveTimeGain = true;
	
	
	/// MenuScnene
	
	public boolean stats = true;
	
	public Upgrade upgrade;
	public String gameSavedString ="";

	
	public Scene() {
		super();
		this.stage = 1;
		this.xFond1 = 0;
		this.xFond2 = 800;
		this.dx = 0;
		this.xPos = -1;
		this.yDmgString = 0;
		
		icoFond1 = new ImageIcon(getClass().getResource("/images/stageForest.png"));
		imgFond1 = icoFond1.getImage();
		imgFond2 = icoFond1.getImage();
		
		icoFondMenu = new ImageIcon(getClass().getResource("/images/fondMenuScene.png"));
		imgFondMenu = icoFondMenu.getImage();

		hero=new Hero(50, 183);
		golem=new Golem(150, 175);

		if(this.hero.getStageMax() == 10) {
			setGolem();
			tabEnemi.clear();
		} else {
			setMonster();
		}
	
		if(this.hero.getStageMax() <= 10) {
			icoFond1 = new ImageIcon(getClass().getResource("/images/stageForest.png"));
			imgFond1 = icoFond1.getImage();
			imgFond2 = icoFond1.getImage();
			
		} else if(this.hero.getStageMax() > 10) {
			icoFond1 = new ImageIcon(getClass().getResource("/images/stageLava.png"));
			imgFond1 = icoFond1.getImage();
			imgFond2 = icoFond1.getImage();
		}
		
		
		this.setLayout(null);
	
	
		upgrade = new Upgrade(hero);
		
		upgrade.btnDmg.setBounds(30, 500, 100, 20);
		this.add(upgrade.btnDmg);
		
		upgrade.btnHealth.setBounds(150, 500, 100, 20);
		this.add(upgrade.btnHealth);
		
		//if(this.hero.isSlimHerbe() == true || this.hero.isSlimFeu() == true || this.hero.isSlimEau() == true) 
		upgrade.btnHeroFarm.setBounds(270, 500, 100, 20);
		this.add(upgrade.btnHeroFarm);
		
		upgrade.btnSave.setBounds(500, 500, 100, 20);
		this.add(upgrade.btnSave);
		
		upgrade.btnStats.setBounds(400, 500, 30, 30);
		this.add(upgrade.btnStats);

		this.setFocusable(true);
		this.requestFocusInWindow();
		
		
		Thread chronoEcran=new Thread(new Chrono());
		chronoEcran.start();
		
		
		
	}

	//   GETTERS   //
	public int getDx() {return dx;}

	public int getxPos() {return xPos;}
	
	public int getyDmgString() {return yDmgString;}
	
	public int getStage() {return stage;}
	
	public Image getImgFond1() {return imgFond1;}
	
	public Image getImgFond2() {return imgFond2;}

	public ImageIcon getIcoFond1() {return icoFond1;}

	//   SETTERS   //
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public void setDx(int dx) {this.dx = dx;}

	public void setxPos(int xPos) {this.xPos = xPos;}
	
	public void setyDmgString(int yDmgString) {this.yDmgString = yDmgString;}
	
	public void setStage(int stage) {this.stage = stage;}
	
	public void setImgFond1(Image imgFond1) {this.imgFond1 = imgFond1;}
	
	public void setImgFond2(Image imgFond2) {this.imgFond2 = imgFond2;}
	
	public void setIcoFond1(ImageIcon icoFond1) {this.icoFond1 = icoFond1;}


	//  METHODS   //
	public void deplacementFond() {

		if(this.xFond1 <= -800) {this.xFond1 = 800;} 
		else if(this.xFond2 <= -800) {this.xFond2 = 800;}
	
		if(this.xPos >= 0 && this.xPos <= 800) {
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}

	}
	

	
	public void setMonster() {
		System.out.println("Stage : "+this.stage);
		if(this.stage <= 10) {
			enemi=new Enemi(150, 175);
			enemi.setHealth(enemi.getHealth() * this.stage);
			enemi.setGoldValue(enemi.getGoldValue() + this.stage);
			enemi.setDmg(enemi.getDmg() * this.stage);
			
			enemi2=new Enemi(200, 175);
			enemi2.setHealth(enemi2.getHealth() * this.stage);
			enemi2.setGoldValue(enemi2.getGoldValue() + this.stage);
			enemi2.setDmg(enemi2.getDmg() * this.stage);
			enemi2.compteurMarche = 2;
			
			enemi3=new Enemi(300, 175);
			enemi3.setHealth(enemi3.getHealth() * this.stage);
			enemi3.setGoldValue(enemi3.getGoldValue() + this.stage);
			enemi3.setDmg(enemi3.getDmg() * this.stage);
			enemi3.compteurMarche = 1;
			
			enemi4=new Enemi(400, 175);
			enemi4.setHealth(enemi4.getHealth() * this.stage);
			enemi4.setGoldValue(enemi4.getGoldValue() + this.stage);
			enemi4.setDmg(enemi4.getDmg() * this.stage);
			enemi4.compteurMarche = 3;
			
			enemi5=new Enemi(500, 175);
			enemi5.setHealth(enemi5.getHealth() * this.stage);
			enemi5.setGoldValue(enemi5.getGoldValue() + this.stage);
			enemi5.setDmg(enemi5.getDmg() * this.stage);
			enemi5.compteurMarche = 1;
			
			enemi6=new Enemi(550, 175);
			enemi6.setHealth(enemi6.getHealth() * this.stage);
			enemi6.setGoldValue(enemi6.getGoldValue() + this.stage);
			enemi6.setDmg(enemi6.getDmg() * this.stage);
			enemi6.compteurMarche = 0;
			
			enemi7=new Enemi(590, 175);
			enemi7.setHealth(enemi7.getHealth() * this.stage);
			enemi7.setGoldValue(enemi7.getGoldValue() + this.stage);
			enemi7.setDmg(enemi7.getDmg() * this.stage);
			enemi7.compteurMarche = 2;
			
			enemi8=new Enemi(620, 175);
			enemi8.setHealth(enemi8.getHealth() * this.stage);
			enemi8.setGoldValue(enemi8.getGoldValue() + this.stage);
			enemi8.setDmg(enemi8.getDmg() * this.stage);
			enemi8.compteurMarche = 0;
			
			enemi9=new Enemi(690, 175);
			enemi9.setHealth(enemi9.getHealth() * this.stage);
			enemi9.setGoldValue(enemi9.getGoldValue() + this.stage);
			enemi9.setDmg(enemi9.getDmg() * this.stage);
			enemi9.compteurMarche = 3;
			
			enemi10=new Enemi(720, 175);
			enemi10.setHealth(enemi10.getHealth() * this.stage);
			enemi10.setGoldValue(enemi10.getGoldValue() + this.stage);
			enemi10.setDmg(enemi10.getDmg() * this.stage);
			enemi10.compteurMarche = 1;
			
			tabEnemi=new ArrayList<Personnages>();
			
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
			
		} else if (this.stage > 10) {
			flamme=new Flamme(150, 170);
			flamme.setHealth(flamme.getHealth() * this.stage);
			flamme.setGoldValue(flamme.getGoldValue() + this.stage);
			flamme.setDmg(flamme.getDmg() * this.stage);
			
			flamme2=new Flamme(200, 170);
			flamme2.setHealth(flamme2.getHealth() * this.stage);
			flamme2.setGoldValue(flamme2.getGoldValue() + this.stage);
			flamme2.setDmg(flamme2.getDmg() * this.stage);
			flamme2.compteurMarche = 2;
			
			flamme3=new Flamme(300, 170);
			flamme3.setHealth(flamme3.getHealth() * this.stage);
			flamme3.setGoldValue(flamme3.getGoldValue() + this.stage);
			flamme3.setDmg(flamme3.getDmg() * this.stage);
			flamme3.compteurMarche = 1;
			
			flamme4=new Flamme(400, 170);
			flamme4.setHealth(flamme4.getHealth() * this.stage);
			flamme4.setGoldValue(flamme4.getGoldValue() + this.stage);
			flamme4.setDmg(flamme4.getDmg() * this.stage);
			flamme4.compteurMarche = 3;
			
			flamme5=new Flamme(500, 170);
			flamme5.setHealth(flamme5.getHealth() * this.stage);
			flamme5.setGoldValue(flamme5.getGoldValue() + this.stage);
			flamme5.setDmg(flamme5.getDmg() * this.stage);
			flamme5.compteurMarche = 1;
			
			flamme6=new Flamme(550, 170);
			flamme6.setHealth(flamme6.getHealth() * this.stage);
			flamme6.setGoldValue(flamme6.getGoldValue() + this.stage);
			flamme6.setDmg(flamme6.getDmg() * this.stage);
			flamme6.compteurMarche = 0;
			
			flamme7=new Flamme(590, 170);
			flamme7.setHealth(flamme7.getHealth() * this.stage);
			flamme7.setGoldValue(flamme7.getGoldValue() + this.stage);
			flamme7.setDmg(flamme7.getDmg() * this.stage);
			flamme7.compteurMarche = 2;
			
			flamme8=new Flamme(620, 170);
			flamme8.setHealth(flamme8.getHealth() * this.stage);
			flamme8.setGoldValue(flamme8.getGoldValue() + this.stage);
			flamme8.setDmg(flamme8.getDmg() * this.stage);
			flamme8.compteurMarche = 0;
			
			flamme9=new Flamme(690, 170);
			flamme9.setHealth(flamme9.getHealth() * this.stage);
			flamme9.setGoldValue(flamme9.getGoldValue() + this.stage);
			flamme9.setDmg(flamme9.getDmg() * this.stage);
			flamme9.compteurMarche = 3;
			
			flamme10=new Flamme(720, 170);
			flamme10.setHealth(flamme10.getHealth() * this.stage);
			flamme10.setGoldValue(flamme10.getGoldValue() + this.stage);
			flamme10.setDmg(flamme10.getDmg() * this.stage);
			flamme10.compteurMarche = 1;
			
			tabEnemi=new ArrayList<Personnages>();
			
			tabEnemi.add(flamme);
			tabEnemi.add(flamme2);
			tabEnemi.add(flamme3);
			tabEnemi.add(flamme4);
			tabEnemi.add(flamme5);
			tabEnemi.add(flamme6);
			tabEnemi.add(flamme7);
			tabEnemi.add(flamme8);
			tabEnemi.add(flamme9);
			tabEnemi.add(flamme10);
		}
			
	
	}
	
	public void setGolem() {
		golem=new Golem(150, 175);
		this.tabEnemi.clear();
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
		if(this.stage == 10) {
			if(this.hero.proche(this.golem)) {
				this.hero.contact(this.golem);
				if(this.golem.isVivant() == false) {
					this.hero.setLibre(true);
				}
			}
		}
		// changement de menu
		if(this.stats == true) {	
			upgrade.btnDmg.setVisible(true);
			upgrade.btnHealth.setVisible(true);
			upgrade.btnHeroFarm.setVisible(true);
			upgrade.btnSave.setVisible(true);	
		}  else {
			upgrade.btnDmg.setVisible(false);
			upgrade.btnHealth.setVisible(false);
			upgrade.btnHeroFarm.setVisible(false);
			upgrade.btnSave.setVisible(false);
		}
	
		// changement de stage
		if(this.getxPos() >= 799 || this.golem.getHealth() <=0) {	
			Main.changeScreentoLoading();

			this.xPos = -1;		
			stage++;
			hero.setStageMax(hero.getStageMax() + 1);
				
			if(this.stage != 10) {
				setMonster();
			} else {
				setGolem();			
			}
			if(this.hero.getStageMax() > 10) {
				icoFond1 = new ImageIcon(getClass().getResource("/images/stageLava.png"));
				imgFond1 = icoFond1.getImage();
				imgFond2 = icoFond1.getImage();
			}
			
			this.golem.setHealth(100);
		}
		
		//mouvement du fond
		if(this.xPos == -1) {
			this.xPos = 0;
			this.xFond1 = 0;
			this.xFond2 = 800;
		
		}
		
		
		if(this.xPos >= 0 && this.xPos <= 800) {
			for(int i = 0; i < tabEnemi.size(); i++) {
				this.tabEnemi.get(i).deplacement();
			}
			this.golem.deplacement();
			
		}
		
		if(this.hero.isLibre() == true) {
			this.hero.setMarche(true);
			this.setDx(10);
		} else {
			this.hero.setMarche(false);
			this.setDx(0);
		}
		g2.setColor(Color.WHITE);
		//image des fond 1 et 2
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);

		// images des monstre
	
		for(int i = 0; i < this.tabEnemi.size(); i++) {
			if(this.stage<= 10) {
				if(this.tabEnemi.get(i).isVivant() == true) {
					g2.drawImage(this.tabEnemi.get(i).marche("oeil", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
				} else {
					g2.drawImage(this.tabEnemi.get(i).mortImg("oeil", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
				}
			} else if(this.stage > 10) {
				if(this.tabEnemi.get(i).isVivant() == true) {
					g2.drawImage(this.tabEnemi.get(i).marche("flamme", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
				} else {
					g2.drawImage(this.tabEnemi.get(i).marche("flamme", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);

					//g2.drawImage(this.tabEnemi.get(i).mortImg("flamme", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
				}
			}
			
			
		}
		if(this.stage == 10) {
			g2.drawImage(this.golem.marche("golem", 100), this.golem.getX(), this.golem.getY(), null);
		}
		

		// image du hero
		if(this.hero.isVivant() == true) {
			if(this.hero.isEnCombat() == true) {
				g2.drawImage(this.hero.combatImg(hero.getSelectedHero(), 200), 50, 183, null);
				for(int i = 0; i < tabEnemi.size(); i++) {
					if(this.hero.proche(this.tabEnemi.get(i)) == true && this.tabEnemi.get(i).isVivant() == true) {
						g2.drawString(""+this.tabEnemi.get(i).getHealth() , 135, 180);
					}
				}
				if(this.hero.proche(golem) == true && this.golem.isVivant() == true && this.stage == 10) {
					
					g2.drawString(""+this.golem.getHealth() , 132, 170);
				}
			} else {
				g2.drawImage(this.hero.marche(hero.getSelectedHero(), 100), 50, 183, null);
			}
		} else {
			g2.drawImage(this.hero.mortImg("hero", 200), 50, 183, null);
			Main.changeScreentoLoading();
		}
		
		// nom du joueur
		g2.drawString(this.hero.getPlayerName(), 65, 175);
		
		// information sur le stage courant
		Font font = new Font("LucidaSans", Font.PLAIN, 20);
		AttributedString atString= new AttributedString("Stage : " + this.stage);
		atString.addAttribute(TextAttribute.FONT, font);
		
	
		
		
		g2.drawString(atString.getIterator(), 320, 30);
		
		
		//information sur les gain durant l'incativité
		if(this.showGoldGainInactiveTimeGain == true) {
			new Thread(new Runnable()
			{
			    @Override
			    public void run()
			    {
			        try {
			        	inactiveTimeGain = "You gain "+(LoginPanel.minuteOutOfGame * hero.getStageMax())+ " Gold !";
						Thread.sleep(4000);
						inactiveTimeGain = "";
					} catch (InterruptedException e) {
						e.printStackTrace();
					}      
			    }
			}).start();
			this.showGoldGainInactiveTimeGain = false;
		}
		
		
		g2.drawString(inactiveTimeGain, 320, 50);
		
		///    MENU SCENE    ///
		
		if(this.stats == true) {
			g2.drawImage(this.imgFondMenu, 0, 300, null);
			
			g2.drawString("Health : " + this.hero.getHealth() , 30, 330);
			
			g2.drawString("Damage : " + this.hero.getDmg(), 130, 330);
			
			g2.drawString("Gold : " + this.hero.getGold(), 230, 330);
			
			g2.drawString(this.hero.getDmg()*10+" Gold", 60, 490);
			
			g2.drawString(this.hero.getHealthLvl()*20+" Gold", 175, 490);
			
			g2.drawString(gameSavedString, 515, 490);
		} else {
			g2.drawImage(this.imgFondMenu, 0, 300, null);
		}
		
		
		
		
	}
	


	
	
}
