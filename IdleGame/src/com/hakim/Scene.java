package com.hakim;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.io.IOException;

import com.hakim.gameplay.Upgrade;
import com.hakim.item.Potion;
import com.hakim.item.RuneDmg;
import com.hakim.logIn.LoginPanel;
import com.hakim.personnages.Enemi;
import com.hakim.personnages.Flamme;
import com.hakim.personnages.Golem;
import com.hakim.personnages.Hero;
import com.hakim.personnages.Personnages;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	
	private Image imgFondMenuStats;
	private ImageIcon icoFondMenuStats;
	
	private Image imgFondMenuRelic;
	private ImageIcon icoFondMenuRelic;
	
	private Image imgFondMenuInventory;
	private ImageIcon icoFondMenuInventory;
	
	private Image imgFondMenuEquipement;
	private ImageIcon icoFondMenuEquipement;

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
	
	private JLabel labelHealth;
	private JLabel labelHealthRegen;
	private JLabel labelDefence;
	private JLabel labelDmg;
	private JLabel labelCritChance;
	private JLabel labelCritDmg;
	
	private JLabel labelGold;
	private JLabel labelRelicHerbe;
	private JLabel labelRelicFeu;
	private JLabel labelRelicEau;

	private String inactiveTimeGain = "";
	
	public Golem golem;
	
	private boolean showGoldGainInactiveTimeGain = true;
	public boolean showDetailItem = false;
	
	/// MenuScnene
	
	public boolean stats = true;
	public boolean farm = false;
	public boolean relic = false;
	public boolean inventoryIcon = false;
	public boolean equipement = false;
	
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
		
		icoFondMenuStats = new ImageIcon(getClass().getResource("/images/icon/menuStats.png"));
		imgFondMenuStats = icoFondMenuStats.getImage();
		
		icoFondMenuRelic = new ImageIcon(getClass().getResource("/images/icon/menuRelic.png"));
		imgFondMenuRelic = icoFondMenuRelic.getImage();
		
		icoFondMenuInventory = new ImageIcon(getClass().getResource("/images/icon/menuInventory.png"));
		imgFondMenuInventory = icoFondMenuInventory.getImage();
		
		icoFondMenuEquipement = new ImageIcon(getClass().getResource("/images/icon/menuEquipement.png"));
		imgFondMenuEquipement = icoFondMenuEquipement.getImage();
		
		// img icon stats
		
		labelHealth = new JLabel();
		labelHealth.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/hearthIcon.png")).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		labelHealth.setBounds(10, 350, 64, 64);
		
		labelHealthRegen = new JLabel();
		labelHealthRegen.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/hearthRegenIcon.png")).getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH)));
		labelHealthRegen.setBounds(10, 400, 64, 64);
		
		labelDefence = new JLabel();
		labelDefence.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/shieldIcon.png")).getImage().getScaledInstance(54, 54, Image.SCALE_SMOOTH)));
		labelDefence.setBounds(16, 460, 54, 54);
		
		labelDmg = new JLabel();
		labelDmg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/dmgIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		labelDmg.setBounds(300, 365, 40, 40);
		
		labelCritChance = new JLabel();
		labelCritChance.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/critChanceIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		labelCritChance.setBounds(300, 415, 40, 40);
		
		labelCritDmg = new JLabel();
		labelCritDmg.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/critDmgIcon.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
		labelCritDmg.setBounds(300, 465, 40, 40);
		
		
		labelGold = new JLabel();
		labelGold.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/goldIcon.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		labelGold.setBounds(500, 5, 32, 32);
		
		
		labelRelicHerbe = new JLabel();
		labelRelicHerbe.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicHerbeIcon.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		labelRelicHerbe.setBounds(600, 5, 32, 32);
		this.add(labelRelicHerbe);
		
		labelRelicFeu = new JLabel();
		labelRelicFeu.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicFeuIcon.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		labelRelicFeu.setBounds(650, 5, 32, 32);
		this.add(labelRelicFeu);
		
		labelRelicEau = new JLabel();
		labelRelicEau.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicEauIcon.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
		labelRelicEau.setBounds(700, 5, 32, 32);
		this.add(labelRelicEau);

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
		
		upgrade.btnHealth.setBounds(150, 370, 100, 35);
		this.add(upgrade.btnHealth);
		
		upgrade.btnHealthRegen.setBounds(150, 420, 100, 35);
		this.add(upgrade.btnHealthRegen);
		
		upgrade.btnDefence.setBounds(150, 470, 100, 35);
		this.add(upgrade.btnDefence);

		upgrade.btnDmg.setBounds(400, 370, 100, 35);
		this.add(upgrade.btnDmg);
		
		upgrade.btnCritChance.setBounds(400, 420, 100, 35);
		this.add(upgrade.btnCritChance);
		
		upgrade.btnCritDmg.setBounds(400, 470, 100, 35);
		this.add(upgrade.btnCritDmg);

		//if(this.hero.isSlimHerbe() == true || this.hero.isSlimFeu() == true || this.hero.isSlimEau() == true) 
		
		upgrade.btnSave.setBounds(500, 500, 100, 20);
		this.add(upgrade.btnSave);
		
		upgrade.btnStats.setBounds(25, 305, 45, 40);
		this.add(upgrade.btnStats);
		
		upgrade.btnFarm.setBounds(125, 306, 45, 40);
		this.add(upgrade.btnFarm);
		
		upgrade.btnRelic.setBounds(222, 307, 45, 40);
		this.add(upgrade.btnRelic);
		
		upgrade.btnInventory.setBounds(325, 305, 45, 40);
		this.add(upgrade.btnInventory);
		
		upgrade.btnEquipement.setBounds(425, 305, 45, 40);
		this.add(upgrade.btnEquipement);
		

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
		this.add(labelGold);
		this.add(labelRelicHerbe);
		this.add(labelRelicFeu);
		this.add(labelRelicEau);
		
		if(this.stats == true) {	
			try {
				Image goldImage = ImageIO.read(getClass().getResource("/images/icon/goldIcon.png"));
				upgrade.btnDmg.setIcon(new ImageIcon(goldImage));
				upgrade.btnHealth.setIcon(new ImageIcon(goldImage));
				upgrade.btnHealthRegen.setIcon(new ImageIcon(goldImage));
				upgrade.btnDefence.setIcon(new ImageIcon(goldImage));
				upgrade.btnCritChance.setIcon(new ImageIcon(goldImage));
				upgrade.btnCritDmg.setIcon(new ImageIcon(goldImage));
			} catch (IOException e) {e.printStackTrace();}
			
			int valueCritChance = 0;
			int valueCritDmg = 0;
			if(Main.scene.hero.equipedItem[0].stats1 == "C") {valueCritChance = valueCritChance + Main.scene.hero.equipedItem[0].stats1Value;}
			if(Main.scene.hero.equipedItem[1].stats1 == "C") {valueCritChance = valueCritChance + Main.scene.hero.equipedItem[1].stats1Value;}
			if(Main.scene.hero.equipedItem[0].stats1 == "I") {valueCritDmg = valueCritDmg + Main.scene.hero.equipedItem[0].stats1Value;}
			if(Main.scene.hero.equipedItem[1].stats1 == "I") {valueCritDmg = valueCritDmg + Main.scene.hero.equipedItem[1].stats1Value;}
			
			upgrade.btnDmg.setText("<html><p style='margin-right:15px;'>" + this.hero.getDmgAvantEquip()*10+"</p></html>");
			upgrade.btnCritChance.setText("<html><p style='margin-right:15px;'>" + (hero.getCritChance()-valueCritChance)*50+"</p></html>");
			upgrade.btnCritDmg.setText("<html><p style='margin-right:15px;'>" + (hero.getCritDmg()-valueCritDmg)*50+"</p></html>");
			upgrade.btnHealth.setText("<html><p style='margin-right:15px;'>" + hero.getHealthLvl()*20+"</p></html>");
			upgrade.btnHealthRegen.setText("<html><p style='margin-right:15px;'>" + hero.getHealthRegen()*50+"</p></html>");
			upgrade.btnDefence.setText("<html><p style='margin-right:15px;'>" + hero.getDefence()*50+"</p></html>");
			

			upgrade.btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
			upgrade.btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40,  35, Image.SCALE_SMOOTH)));
			upgrade.btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

			upgrade.btnDmg.setVisible(true);
			upgrade.btnHealth.setVisible(true);
			upgrade.btnHealthRegen.setVisible(true);
			upgrade.btnDefence.setVisible(true);
			upgrade.btnCritChance.setVisible(true);
			upgrade.btnCritDmg.setVisible(true);

			this.add(labelHealth);
			this.add(labelDmg);
			this.add(labelHealthRegen);
			this.add(labelDefence);
			this.add(labelCritChance);
			this.add(labelCritDmg);
			
		}  else if(this.relic == true) {
			upgrade.btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
			upgrade.btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40,  35, Image.SCALE_SMOOTH)));
			upgrade.btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

			
			upgrade.btnDmg.setVisible(false);
			upgrade.btnHealth.setVisible(false);
			upgrade.btnHealthRegen.setVisible(false);
			upgrade.btnDefence.setVisible(false);
			upgrade.btnCritChance.setVisible(false);
			upgrade.btnCritDmg.setVisible(false);
			
			this.remove(labelHealth);
			this.remove(labelHealthRegen);
			this.remove(labelDmg);
			this.remove(labelDefence);
			this.remove(labelCritChance);
			this.remove(labelCritDmg);

		} else if(this.inventoryIcon == true) {
		
			upgrade.btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(45,  40, Image.SCALE_SMOOTH)));
			upgrade.btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

			
			upgrade.btnDmg.setVisible(false);
			upgrade.btnHealth.setVisible(false);
			upgrade.btnHealthRegen.setVisible(false);
			upgrade.btnDefence.setVisible(false);
			upgrade.btnCritChance.setVisible(false);
			upgrade.btnCritDmg.setVisible(false);

			this.remove(labelHealth);
			this.remove(labelHealthRegen);
			this.remove(labelDmg);
			this.remove(labelDefence);
			this.remove(labelCritChance);
			this.remove(labelCritDmg);

			Main.inventory.btnInventory1.setBounds(80, 380, 50, 50);
			Main.inventory.btnInventory2.setBounds(180, 380, 50, 50);
			Main.inventory.btnInventory3.setBounds(280, 380, 50, 50);
			Main.inventory.btnInventory4.setBounds(380, 380, 50, 50);
			Main.inventory.btnInventory5.setBounds(480, 380, 50, 50);
			
			Main.inventory.btnInventory6.setBounds(80, 440, 50, 50);
			Main.inventory.btnInventory7.setBounds(180, 440, 50, 50);
			Main.inventory.btnInventory8.setBounds(280, 440, 50, 50);
			Main.inventory.btnInventory9.setBounds(380, 440, 50, 50);
			Main.inventory.btnInventory10.setBounds(480, 440, 50, 50);
			
			Main.inventory.btnDelete.setBounds(80, 500, 100, 20);
			Main.inventory.btnEquipe.setBounds(180, 500, 100, 20);
			
			Main.inventory.itemDescription.setBounds(600, 250, 200, 300);
			
			this.add(Main.inventory.btnInventory1);
			this.add(Main.inventory.btnInventory2);
			this.add(Main.inventory.btnInventory3);
			this.add(Main.inventory.btnInventory4);
			this.add(Main.inventory.btnInventory5);
			this.add(Main.inventory.btnInventory6);
			this.add(Main.inventory.btnInventory7);
			this.add(Main.inventory.btnInventory8);
			this.add(Main.inventory.btnInventory9);
			this.add(Main.inventory.btnInventory10);
			
			this.add(Main.inventory.btnDelete);
			this.add(Main.inventory.btnEquipe);
			this.add(Main.inventory.itemDescription);
			
			if(showDetailItem == true) {
				Main.inventory.btnDelete.setVisible(true);
				Main.inventory.btnEquipe.setVisible(true);
				Main.inventory.itemDescription.setVisible(true);
			} else {
				Main.inventory.btnDelete.setVisible(false);
				Main.inventory.btnEquipe.setVisible(false);
				Main.inventory.itemDescription.setVisible(false);
			}

			Potion pPotionWhite = new Potion("white");
			Potion pPotionGreen = new Potion("green");
			Potion pPotionBlue = new Potion("blue");
			Potion pPotionPurple = new Potion("purple");
			Potion pPotionOrange = new Potion("orange");
			
			RuneDmg runeDmgWhite = new RuneDmg("white");
			RuneDmg runeDmgGreen = new RuneDmg("green");
			RuneDmg runeDmgBlue = new RuneDmg("blue");
			RuneDmg runeDmgPurple = new RuneDmg("purple");
			RuneDmg runeDmgOrange = new RuneDmg("orange");
			
			
			if(hero.itemInInventory[0].name != "" && hero.itemInInventory[0].name != null) {
				switch(hero.itemInInventory[0].name) {
				case "PW":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory1.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "":
					System.out.println("pas d'objet");
					break;
				}		
			}
			if(hero.itemInInventory[1].name != "" && hero.itemInInventory[1].name != null) {
				switch(hero.itemInInventory[1].name) {
				case "PW":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory2.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}
				
			}
			if(hero.itemInInventory[2].name != "" && hero.itemInInventory[2].name != null) {
				switch(hero.itemInInventory[2].name) {
				case "PW":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory3.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}			
			}
			if(hero.itemInInventory[3].name != "" && hero.itemInInventory[3].name != null) {
				switch(hero.itemInInventory[3].name) {
				case "PW":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory4.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}			
			}
			if(hero.itemInInventory[4].name != "" && hero.itemInInventory[4].name != null) {
				switch(hero.itemInInventory[4].name) {
				case "PW":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory5.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}
			}
			if(hero.itemInInventory[5].name != "" && hero.itemInInventory[5].name != null) {
				switch(hero.itemInInventory[5].name) {
				case "PW":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory6.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}
			}
			if(hero.itemInInventory[6].name != "" && hero.itemInInventory[6].name != null) {
				switch(hero.itemInInventory[6].name) {
				case "PW":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory7.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}		
			}
			if(hero.itemInInventory[7].name != "" && hero.itemInInventory[7].name != null) {
				switch(hero.itemInInventory[7].name) {
				case "PW":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory8.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}		
			}
			if(hero.itemInInventory[8].name != "" && hero.itemInInventory[8].name != null) {
				switch(hero.itemInInventory[8].name) {
				case "PW":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory9.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}			
			}
			if(hero.itemInInventory[9].name != "" && hero.itemInInventory[9].name != null) {
				switch(hero.itemInInventory[9].name) {
				case "PW":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(pPotionWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PG":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(pPotionGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PB":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(pPotionBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PP":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(pPotionPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "PO":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(pPotionOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDW":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.inventory.btnInventory10.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
					break;
				}	
			}
			
			this.addMouseListener((MouseListener) new MouseAdapter() {
				 @Override
			      public void mouseClicked(MouseEvent e) {
			        Main.scene.showDetailItem = false;	
					Main.inventory.itemDescription.setText(null);
			      }
			});

		} else if (this.equipement == true) {
			upgrade.btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
			upgrade.btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40,  35, Image.SCALE_SMOOTH)));
			upgrade.btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));

			
			upgrade.btnDmg.setVisible(false);
			upgrade.btnHealth.setVisible(false);
			upgrade.btnHealthRegen.setVisible(false);
			upgrade.btnDefence.setVisible(false);
			upgrade.btnCritChance.setVisible(false);
			upgrade.btnCritDmg.setVisible(false);

			
			this.remove(labelHealth);
			this.remove(labelHealthRegen);
			this.remove(labelDmg);
			this.remove(labelDefence);
			this.remove(labelCritChance);
			this.remove(labelCritDmg);

			Main.equipement.btnEquipement1.setBounds(80, 380, 50, 50);
			Main.equipement.btnEquipement2.setBounds(180, 380, 50, 50);
			
			Main.equipement.btnDelete.setBounds(80, 500, 100, 20);
			Main.equipement.btnUnequipe.setBounds(180, 500, 100, 20);
			Main.equipement.itemDescription.setBounds(600, 250, 200, 300);
			
			this.add(Main.equipement.btnEquipement1);
			this.add(Main.equipement.btnEquipement2);
			
			this.add(Main.equipement.btnDelete);
			this.add(Main.equipement.btnUnequipe);
			this.add(Main.equipement.itemDescription);
			
			if(showDetailItem == true) {
				Main.equipement.btnDelete.setVisible(true);
				Main.equipement.btnUnequipe.setVisible(true);
				Main.equipement.itemDescription.setVisible(true);
			} else {
				Main.equipement.btnDelete.setVisible(false);
				Main.equipement.btnUnequipe.setVisible(false);
				Main.equipement.itemDescription.setVisible(false);
			}

			RuneDmg runeDmgWhite = new RuneDmg("white");
			RuneDmg runeDmgGreen = new RuneDmg("green");
			RuneDmg runeDmgBlue = new RuneDmg("blue");
			RuneDmg runeDmgPurple = new RuneDmg("purple");
			RuneDmg runeDmgOrange = new RuneDmg("orange");
			
			if(hero.equipedItem[0].name != "") {
				switch(hero.equipedItem[0].name) {
				case "RDW":
					Main.equipement.btnEquipement1.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.equipement.btnEquipement1.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.equipement.btnEquipement1.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.equipement.btnEquipement1.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.equipement.btnEquipement1.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				}		
			}
			if(hero.equipedItem[1].name != "") {
				switch(hero.equipedItem[1].name) {
				case "RDW":
					Main.equipement.btnEquipement2.setIcon(new ImageIcon(new ImageIcon(runeDmgWhite.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;	
				case "RDG":
					Main.equipement.btnEquipement2.setIcon(new ImageIcon(new ImageIcon(runeDmgGreen.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDB":
					Main.equipement.btnEquipement2.setIcon(new ImageIcon(new ImageIcon(runeDmgBlue.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDP":
					Main.equipement.btnEquipement2.setIcon(new ImageIcon(new ImageIcon(runeDmgPurple.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
				case "RDO":
					Main.equipement.btnEquipement2.setIcon(new ImageIcon(new ImageIcon(runeDmgOrange.img).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
					break;
					
				}	
				
			}
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
			this.setDx(3);
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
					g2.drawImage(this.tabEnemi.get(i).mortImg("flamme", 100), this.tabEnemi.get(i).getX(), this.tabEnemi.get(i).getY(), null);
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
		
		
		//information sur les gain durant l'incativit?
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
		Font myFont = new Font ("Courier New", 1, 17);
		g2.setFont (myFont);
		g2.setColor(Color.BLACK);
		if(this.stats == true) {
			g2.drawImage(this.imgFondMenuStats, 0, 300, null);
			
			g2.drawString(""+this.hero.getHealth()+"/"+(90+this.hero.getHealthLvl()*10) , 70, 390);
			//healthRegen
			g2.drawString(""+this.hero.getHealthRegen() , 70, 440);
			
			g2.drawString(""+this.hero.getDefence(), 70, 490);
			
			g2.drawString("" + this.hero.getDmg(), 360, 390);
			
			g2.drawString("" + this.hero.getCritChance(), 360, 440);
			
			g2.drawString("" + this.hero.getCritDmg(), 360, 490);
			
			g2.drawString(gameSavedString, 495, 490);
		} else if(this.relic == true) {
			g2.drawImage(this.imgFondMenuRelic, 0, 300, null);
			g2.drawString(gameSavedString, 495, 490);
		} else if (this.inventoryIcon == true) {
			g2.drawImage(this.imgFondMenuInventory, 0, 300, null);
			g2.drawString(gameSavedString, 495, 490);
		} else if(this.equipement == true) {
			g2.drawImage(this.imgFondMenuEquipement, 0, 300, null);
			g2.drawString(gameSavedString, 495, 490);
		}
		
		
		g2.setColor(Color.WHITE);
		g2.drawString("" + this.hero.getGold(), 535, 25);
		
		//relic Herbe
		g2.drawString(""+0, 630, 25);
		//relic Feu
		g2.drawString(""+0, 680, 25);
		//relic Eau
		g2.drawString(""+0, 730, 25);
		
	}
	


	
	
}
