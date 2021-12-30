package com.hakim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

import com.hakim.personnages.Hero;


public class Upgrade {
	
	public JButton btnDmg;
	public JButton btnHealth;
	public JButton btnHeroFarm;	
	public JButton btnScene;	

	Upgrade(Hero hero) {
		btnDmg=new JButton("UP DMG");
		btnDmg.setContentAreaFilled(false);
		btnDmg.setBorder(new RoundedBorder(10));
		btnDmg.setForeground(Color.BLUE);
		
		btnHealth = new JButton("UP HEALTH");
		btnHealth.setContentAreaFilled(false);
		btnHealth.setBorder(new RoundedBorder(10));
		btnHealth.setForeground(Color.BLUE);
		
		btnHeroFarm = new JButton("HERO FARM");
		btnHeroFarm.setContentAreaFilled(false);
		btnHeroFarm.setBorder(new RoundedBorder(10));
		btnHeroFarm.setForeground(Color.BLUE);
		
		btnScene = new JButton("FIGHT");
		btnScene.setContentAreaFilled(false);
		btnScene.setBorder(new RoundedBorder(10));
		btnScene.setForeground(Color.BLUE);
		
		btnDmg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= hero.getDmg()*10) {
					hero.setGold(hero.getGold()-(hero.getDmg()*10));
					hero.setDmg(hero.getDmg()+1);
				}
			}		
		});
		
		btnHealth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= hero.getHealthLvl()*20) {
					hero.setGold(hero.getGold()-(hero.getHealthLvl()*20));
					hero.setHealth(hero.getHealth() + 10);
					hero.setHealthLvl(hero.getHealthLvl() + 1);
				}
			}		
		});
		
		btnHeroFarm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.changeToFarm();
			}		
		});
		
		btnScene.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.changeScreentoScene();
			}		
		});
		
		
	}
	
	//   METHODS   //

	
}
