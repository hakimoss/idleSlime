package com.hakim;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeroFarm extends JPanel {
	public Upgrade upgrade;
	
	
	public HeroFarm() {
		this.setLayout(null);
		
		upgrade = new Upgrade(Main.scene.hero);
		
		upgrade.btnDmg.setBounds(30, 500, 100, 20);
		this.add(upgrade.btnDmg);
		
		upgrade.btnHealth.setBounds(150, 500, 100, 20);
		this.add(upgrade.btnHealth);
		
		upgrade.btnScene.setBounds(270, 500, 100, 20);
		this.add(upgrade.btnScene);
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		
		
		
		///    MENU SCENE    ///
		
		g2.drawImage(Main.scene.imgFondMenu, 0, 300, null);
		
		g2.drawString("Health : " + Main.scene.hero.getHealth() , 30, 330);
		
		g2.drawString("Damage : " + Main.scene.hero.getDmg(), 130, 330);
		
		g2.drawString("Gold : " + Main.scene.hero.getGold(), 230, 330);
		
		g2.drawString(Main.scene.hero.getDmg()*10+" Gold", 60, 490);
		
		g2.drawString(Main.scene.hero.getHealthLvl()*20+" Gold", 175, 490);
	}
	
}