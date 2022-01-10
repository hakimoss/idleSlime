package com.hakim.gameplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;

import com.hakim.ChronoSelectedCharatere;
import com.hakim.Main;
import com.hakim.Profil;
import com.hakim.RoundedBorder;
import com.hakim.logIn.LogIn;
import com.hakim.personnages.Hero;


public class Upgrade {
	
	public JButton btnDmg;
	public JButton btnHealth;
	public JButton btnHeroFarm;	
	public JButton btnScene;	
	public JButton btnSave;
	
	public JLabel btnStats;
	
	public Thread chrono;
	
	
	private static boolean exit;

	public Upgrade(Hero hero) {
		
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
		
		btnSave = new JButton("SAVE");
		btnSave.setContentAreaFilled(false);
		btnSave.setBorder(new RoundedBorder(10));
		btnSave.setForeground(Color.RED);

	
		
		btnStats = new JLabel(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")));
		
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
				 
				chrono = new Thread(new ChronoSelectedCharatere());
				
				chrono.start();
				exit = false;		
			
				
				Main.changeToFarm();
			}		
		});
		
		btnScene.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				exit = true;
				
				
				
				Main.changeScreentoScene();
			}		
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Profil p = new Profil(Main.scene.hero.getEmail(), Main.scene.hero.getStageMax(), Main.scene.hero.getHealthLvl(), Main.scene.hero.getDmg(), Main.scene.hero.getGold());
				LogIn logIn = new LogIn();
				try {
					logIn.saveAccount(p);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				new Thread(new Runnable()
				{
				    @Override
				    public void run()
				    {
				    	Main.scene.gameSavedString = "Game Saved!";
				        try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}      
				        Main.scene.gameSavedString = "";
				    }
				}).start();
			}
			
		});
		
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) 
		    {
				
				System.out.println("mouse clicked ! ");
				if(Main.scene.stats == false) {
					Main.scene.stats = true;
					
			
				} else {
					Main.scene.stats = false;
					
				}
		    }
		});
		
	}
	
	

	
	//   GETTERS   //
	public static boolean isExit() {return exit;}

	//   SETTERS   //

	//   METHODS   //

	
}
