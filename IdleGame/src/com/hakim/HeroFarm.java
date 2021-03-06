package com.hakim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.hakim.gameplay.Upgrade;
import com.hakim.personnages.Personnages;

@SuppressWarnings("serial")
public class HeroFarm extends JPanel {
	public Upgrade upgrade;
	
	private Personnages p1;
	private Personnages p2;
	private Personnages p3;
	
	private Image imgFarm;
	private ImageIcon icoFarm;
	

	public HeroFarm() {
		this.setLayout(null);
		
		upgrade = new Upgrade(Main.scene.hero);
		

		icoFarm = new ImageIcon(getClass().getResource("/images/icon/menuFarm.png"));
		imgFarm = icoFarm.getImage();
		
		
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
		
		upgrade.btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		upgrade.btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
		upgrade.btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		upgrade.btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		upgrade.btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

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
		
		g2.drawImage(this.imgFarm, 0, 300, null);
			
	
	}
	
}
;