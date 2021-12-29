package com.hakim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

import com.hakim.personnages.Hero;


public class Upgrade {
	public JButton btnDmg;
	
	public  JButton btnHealth;

	

	Upgrade(Hero hero) {
		btnDmg=new JButton("UP DMG");
		btnDmg.setContentAreaFilled(false);
		
		btnDmg.setBorder(new RoundedBorder(10));
		btnDmg.setForeground(Color.BLUE);
		
		btnHealth = new JButton("UP HEALTH");
		btnHealth.setContentAreaFilled(false);
		
		btnHealth.setBorder(new RoundedBorder(10));
		btnHealth.setForeground(Color.BLUE);
		
		
		
		btnDmg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bonjours");
				if(hero.getGold() >= hero.getDmg()*10) {
					hero.setGold(hero.getGold()-(hero.getDmg()*10));
					hero.setDmg(hero.getDmg()+1);
				
				}
			}
			
		});
		
		btnHealth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bonjours");
				if(hero.getGold() >= hero.getHealthLvl()*20) {
					hero.setGold(hero.getGold()-(hero.getHealthLvl()*20));
					hero.setHealth(hero.getHealth() + 10);
					hero.setHealthLvl(hero.getHealthLvl() + 1);
				
				}
			}
			
		});
	}
	
	//   METHODS   //

	
}
