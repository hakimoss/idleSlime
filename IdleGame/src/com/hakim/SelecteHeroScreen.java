package com.hakim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.hakim.logIn.LoginPanel;
import com.hakim.personnages.Personnages;

@SuppressWarnings("serial")
public class SelecteHeroScreen extends JPanel {

	private JButton slimHerbe;
	private JButton slimFeu;
	private JButton slimEau;
	
	private Personnages p1;
	private Personnages p2;
	private Personnages p3;
	
	public SelecteHeroScreen() {
		slimHerbe = new JButton("Herbe");
		slimHerbe.setBounds(30, 200, 100, 20);
		this.add(slimHerbe);
		
		slimFeu=new JButton("Feu");
		slimFeu.setBounds(150, 200, 100, 20);
		this.add(slimFeu);
		
		slimEau=new JButton("Eau");
		slimEau.setBounds(270, 200, 100, 20);
		this.add(slimEau);
		
		p1=new Personnages(69, 49, 100, 100);
		p2=new Personnages(69, 49, 150, 100);
		p3=new Personnages(69, 49, 200, 100);
		

		
		
		
		slimHerbe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			
				Main.scene.hero.setSelectedHero("heroHerbe");
				
				Main.frame.getContentPane().removeAll();
				Main.frame.getContentPane().invalidate();
				Main.frame.setContentPane(Main.scene);
				Main.frame.revalidate();
				Main.frame.repaint();

			}
			
		});
		

		slimFeu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.scene.hero.setSelectedHero("heroFeu");
				Main.frame.getContentPane().removeAll();
				Main.frame.getContentPane().invalidate();
				Main.frame.setContentPane(Main.scene);
				Main.frame.revalidate();
				Main.frame.repaint();
			}
			
		});
		

		slimEau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.scene.hero.setSelectedHero("heroEau");
				Main.frame.getContentPane().removeAll();
				Main.frame.getContentPane().invalidate();
				Main.frame.setContentPane(Main.scene);
				Main.frame.revalidate();
				Main.frame.repaint();
			}
			
		});

	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2=(Graphics2D) g;
		
		
		g2.drawImage(p1.marche("heroHerbe", 100), 50, 183, null);
		
		g2.drawImage(p2.marche("heroFeu", 100), 150, 183, null);
		
		g2.drawImage(p3.marche("heroEau", 100), 250, 183, null);
		
		
		
		
		///    MENU SCENE    ///
		
		g2.drawImage(Main.scene.imgFondMenu, 0, 300, null);
		
		g2.drawString("Health : " + Main.scene.hero.getHealth() , 30, 330);
		
		g2.drawString("Damage : " + Main.scene.hero.getDmg(), 130, 330);
		
		g2.drawString("Gold : " + Main.scene.hero.getGold(), 230, 330);
		
		g2.drawString(Main.scene.hero.getDmg()*10+" Gold", 60, 490);
		
		g2.drawString(Main.scene.hero.getHealthLvl()*20+" Gold", 175, 490);
	}
}