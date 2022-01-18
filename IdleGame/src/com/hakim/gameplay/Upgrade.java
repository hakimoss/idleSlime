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
import java.awt.Image;

import com.hakim.ChronoSelectedCharatere;
import com.hakim.Main;
import com.hakim.Profil;
import com.hakim.RoundedBorder;
import com.hakim.logIn.LogIn;
import com.hakim.personnages.Hero;


public class Upgrade {
	
	public JButton btnDmg;
	public JButton btnHealth;
	public JButton btnSave;
	public JButton btnHealthRegen;
	
	public JLabel btnStats;
	public JLabel btnFarm;
	public JLabel btnRelic;
	public JLabel btnInventory;
	public JLabel btnEquipement;

	public Thread chrono;	
	
	private static boolean exit = true;
	
	

	public Upgrade(Hero hero) {
		
		
		btnDmg=new JButton();
		btnDmg.setContentAreaFilled(false);
		btnDmg.setFocusPainted(false);
		btnDmg.setBorder(new RoundedBorder(3));
		btnDmg.setForeground(Color.BLUE);
		
		btnHealth = new JButton();
		btnHealth.setContentAreaFilled(false);
		btnHealth.setFocusPainted(false);
		btnHealth.setBorder(new RoundedBorder(3));
		btnHealth.setForeground(Color.BLUE);
		
		btnHealthRegen = new JButton();
		btnHealthRegen.setContentAreaFilled(false);
		btnHealthRegen.setFocusPainted(false);
		btnHealthRegen.setBorder(new RoundedBorder(3));
		btnHealthRegen.setForeground(Color.BLUE);
		
		btnSave = new JButton("SAVE");
		btnSave.setContentAreaFilled(false);
		btnSave.setFocusPainted(false);
		btnSave.setBorder(new RoundedBorder(3));
		btnSave.setForeground(Color.RED);

		btnStats = new JLabel();
		btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
		//btnStats = new JLabel(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")));
		
		btnFarm = new JLabel();
		btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		
		btnRelic = new JLabel();
		btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		
		btnInventory = new JLabel();
		btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		
		btnEquipement = new JLabel();
		btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
		
		btnDmg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= hero.getDmg()*10) {
					hero.setGold(hero.getGold()-(hero.getDmg()*10));
					hero.setDmg(hero.getDmg()+1);
					btnDmg.setText("DMG " + hero.getDmg()*10);
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
					btnHealth.setText("HEALTH " + hero.getHealthLvl()*20);
				}
			}		
		});
		
		btnHealthRegen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= hero.getHealthRegen()*50) {
					hero.setGold(hero.getGold()-(hero.getHealthRegen()*50));
					hero.setHealthRegen(hero.getHealthRegen()+1);
					btnHealthRegen.setText("REGEN " + hero.getHealthRegen()*50);
				}
			}
			
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Profil p = new Profil(Main.scene.hero.getEmail(), Main.scene.hero.getStageMax(), Main.scene.hero.getHealthLvl(), Main.scene.hero.getHealthRegen(), Main.scene.hero.getDmg(), Main.scene.hero.getGold());
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
		
		btnFarm.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) 
		    {
				

				if(exit == true) {
					chrono = new Thread(new ChronoSelectedCharatere());

					Main.scene.farm = false;
					chrono.start();
					exit = false;		
					Main.changeToFarm();
				}
		    }
		});
		
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) 
		    {
				btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
				btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

				exit = true;
				Main.scene.farm = false;
				Main.scene.relic = false;
				Main.scene.stats = true;
				Main.scene.inventoryIcon = false;
				Main.scene.equipement = false;

				Main.changeScreentoScene();

			
		    }
		});
		
		btnRelic.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) 
		    {
				
				btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
				btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

				exit = true;
				Main.scene.relic = true;
				Main.scene.stats = false;
				Main.scene.farm = false;
				Main.scene.inventoryIcon = false;
				Main.scene.equipement = false;


				Main.changeScreentoScene();

			
		    }
		});
		
		btnInventory.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
				btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));

				exit = true;
				Main.scene.relic = false;
				Main.scene.stats = false;
				Main.scene.farm = false;
				Main.scene.inventoryIcon = true;
				Main.scene.equipement = false;

				

				Main.changeScreentoScene();
		    }
		});
		
		btnEquipement.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnRelic.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/relicIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnFarm.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/farmIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnInventory.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/inventoryIcon.png")).getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH)));
				btnEquipement.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/equipementIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));

				
				exit = true;
				Main.scene.relic = false;
				Main.scene.stats = false;
				Main.scene.farm = false;
				Main.scene.inventoryIcon = false;
				Main.scene.equipement = true;
				
			
				

				Main.changeScreentoScene();
		    }
		});
		
		
		
	}
	
	

	
	//   GETTERS   //
	public static boolean isExit() {return exit;}

	//   SETTERS   //

	//   METHODS   //

	
}
