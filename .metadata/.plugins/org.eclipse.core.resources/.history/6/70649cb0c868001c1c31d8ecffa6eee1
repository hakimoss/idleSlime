package com.hakim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

import com.hakim.personnages.Hero;


public class Upgrade {
	public JButton btnDmg;
	public int valueDmgGold;

	

	Upgrade(Hero hero) {
		btnDmg=new JButton("UP DMG");
		btnDmg.setContentAreaFilled(false);
		
		btnDmg.setBorder(new RoundedBorder(10));
		btnDmg.setForeground(Color.BLUE);
		
		
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
	}
	
	//   METHODS   //

	
}
