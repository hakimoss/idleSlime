package com.hakim;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuScene extends JPanel {

	JLabel labelHealth;
	JButton btnHealth;
	
	JLabel labelDmg;
	JButton btnDmg;
	
	Image imgFond;
	ImageIcon icoFond;
	
	public MenuScene() {
		super();
		
		icoFond=new ImageIcon(getClass().getResource("/images/fondMenuScene.png"));
		imgFond=icoFond.getImage();
		
		this.setSize(400,600);
		labelHealth = new JLabel("health");
		btnHealth = new JButton("UP Health");
		
		labelDmg = new JLabel("dmg");
		btnDmg = new JButton("UP Dmg");
		
		this.add(labelHealth);
		this.add(btnHealth);
		this.add(labelDmg);
		this.add(btnDmg);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		
		g2.drawImage(this.imgFond, 0, 400, null);
	} 
}
