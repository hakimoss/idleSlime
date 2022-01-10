package com.hakim;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.hakim.gameplay.Upgrade;
import com.hakim.personnages.Personnages;

@SuppressWarnings("serial")
public class HeroFarm extends JPanel {
	public Upgrade upgrade;
	
	private Personnages p1;
	private Personnages p2;
	private Personnages p3;
	
	

	public HeroFarm() {
		this.setLayout(null);
		
		upgrade = new Upgrade(Main.scene.hero);
		
		upgrade.btnDmg.setBounds(30, 500, 100, 20);
		this.add(upgrade.btnDmg);
		
		upgrade.btnHealth.setBounds(150, 500, 100, 20);
		this.add(upgrade.btnHealth);
		
		upgrade.btnScene.setBounds(270, 500, 100, 20);
		this.add(upgrade.btnScene);
		
		upgrade.btnSave.setBounds(500, 500, 100, 20);
		this.add(upgrade.btnSave);
		

		p1=new Personnages(69, 49, 100, 100);
		p2=new Personnages(69, 49, 150, 100);
		p3=new Personnages(69, 49, 200, 100);
		
		
		
			
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		if(Main.scene.hero.isSlimHerbe() == true) {
			g2.drawImage(p1.marche("heroHerbe", 100), 168, 130, null);

		}
		if(Main.scene.hero.isSlimFeu() == true) {
			g2.drawImage(p2.marche("heroFeu", 100), 368, 130, null);

		}
		if(Main.scene.hero.isSlimEau() == true) {
			g2.drawImage(p3.marche("heroEau", 100), 568, 130, null);

		}
		
		
		
		
	
		///    MENU SCENE    ///
		
		if(Main.scene.stats == true) {
			g2.drawImage(Main.scene.imgFondMenu, 0, 300, null);
			
			g2.drawString("Health : " + Main.scene.hero.getHealth() , 30, 330);
			
			g2.drawString("Damage : " + Main.scene.hero.getDmg(), 130, 330);
			
			g2.drawString("Gold : " + Main.scene.hero.getGold(), 230, 330);
			
			g2.drawString(Main.scene.hero.getDmg()*10+" Gold", 60, 490);
			
			g2.drawString(Main.scene.hero.getHealthLvl()*20+" Gold", 175, 490);
		}
		
	}
	
}
;