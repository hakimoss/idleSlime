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
	public JButton btnCritChance;
	public JButton btnCritDmg;
	public JButton btnHealth;
	public JButton btnHealthRegen;
	public JButton btnDefence;
	
	public JButton btnSave;
	
	public JLabel btnStats;
	public JLabel btnFarm;
	public JLabel btnRelic;
	public JLabel btnInventory;
	public JLabel btnEquipement;

	public Thread chrono;	
	
	private static boolean exit = true;

	public Upgrade(Hero hero) {
		
		
		btnDmg=new JButton();		
		btnDmg.setFocusPainted(false);
		btnDmg.setBorder(new RoundedBorder(3));
		btnDmg.setForeground(Color.BLACK);
		btnDmg.setBackground(Color.decode("#605c5e"));
		
		btnCritChance=new JButton();		
		btnCritChance.setFocusPainted(false);
		btnCritChance.setBorder(new RoundedBorder(3));
		btnCritChance.setForeground(Color.BLACK);
		btnCritChance.setBackground(Color.decode("#605c5e"));
		
		btnCritDmg=new JButton();		
		btnCritDmg.setFocusPainted(false);
		btnCritDmg.setBorder(new RoundedBorder(3));
		btnCritDmg.setForeground(Color.BLACK);
		btnCritDmg.setBackground(Color.decode("#605c5e"));
		
		btnHealth = new JButton();
		btnHealth.setFocusPainted(false);
		btnHealth.setBorder(new RoundedBorder(3));
		btnHealth.setForeground(Color.BLACK);
		btnHealth.setBackground(Color.decode("#605c5e"));
		
		btnHealthRegen = new JButton();
		btnHealthRegen.setFocusPainted(false);
		btnHealthRegen.setBorder(new RoundedBorder(3));
		btnHealthRegen.setForeground(Color.BLACK);
		btnHealthRegen.setBackground(Color.decode("#605c5e"));
		
		btnDefence = new JButton();
		btnDefence.setFocusPainted(false);
		btnDefence.setBorder(new RoundedBorder(3));
		btnDefence.setForeground(Color.BLACK);
		btnDefence.setBackground(Color.decode("#605c5e"));
		
		btnSave = new JButton("SAVE");
		btnSave.setContentAreaFilled(false);
		btnSave.setFocusPainted(false);
		btnSave.setBorder(new RoundedBorder(3));
		btnSave.setForeground(Color.RED);

		btnStats = new JLabel();
		btnStats.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/icon/statsIcon.png")).getImage().getScaledInstance(45, 40, Image.SCALE_SMOOTH)));
		
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
				if(hero.getGold() >= hero.getDmgAvantEquip()*10) {
					hero.setGold(hero.getGold()-(hero.getDmgAvantEquip()*10));
					hero.setDmg(hero.getDmg()+1);
					hero.setDmgAvantEquip(hero.getDmgAvantEquip()+1);
					btnDmg.setText("DMG " + hero.getDmgAvantEquip()*10);
				}
			}		
		});
		
		btnCritChance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int value = 0;
				if(Main.scene.hero.equipedItem[0].stats1 == "C") {value = value + Main.scene.hero.equipedItem[0].stats1Value;}
				if(Main.scene.hero.equipedItem[1].stats1 == "C") {value = value + Main.scene.hero.equipedItem[1].stats1Value;}
				
				if(hero.getGold() >= (hero.getCritChance()-value)*50) {
					hero.setGold(hero.getGold()-((hero.getCritChance()-value)*50));
					hero.setCritChance(hero.getCritChance()+1);
					btnCritChance.setText("CRIT CHANCE " + (hero.getCritChance()-value)*50);
				}
			}
			
		});
		
		btnCritDmg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int value = 0;
				if(Main.scene.hero.equipedItem[0].stats1 == "I") {value = value + Main.scene.hero.equipedItem[0].stats1Value;}
				if(Main.scene.hero.equipedItem[1].stats1 == "I") {value = value + Main.scene.hero.equipedItem[1].stats1Value;}
				
				if(hero.getGold() >= (hero.getCritDmg()-value*50)) {
					hero.setGold(hero.getGold()-((hero.getCritDmg()-value)*50));
					hero.setCritDmg(hero.getCritDmg()+1);
					btnCritDmg.setText("CRIT DMG " + (hero.getCritDmg()-value)*50);
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
		
		btnDefence.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(hero.getGold() >= hero.getDefence()*50) {
					hero.setGold(hero.getGold()-(hero.getDefence()*50));
					hero.setDefence(hero.getDefence()+1);
					btnDefence.setText("DEFENCE " +hero.getDefence()*50);
				}
			}
			
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Profil p = new Profil(Main.scene.hero.getEmail(), Main.scene.hero.getStageMax(), Main.scene.hero.getHealthLvl(), Main.scene.hero.getHealthRegen(), Main.scene.hero.getDefence(), Main.scene.hero.getDmg(), Main.scene.hero.getCritChance(), Main.scene.hero.getCritDmg(), Main.scene.hero.getDmgAvantEquip(), Main.scene.hero.getGold());
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
