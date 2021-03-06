package com.hakim;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.hakim.equipement.Equipement;
import com.hakim.inventory.Inventory;


public class Main {
	
	public static Scene scene;
	public static HeroFarm heroFarm;
	public static LogInScreen logInScreen;
	public static JFrame frame;
	public static Inventory inventory;
	public static Equipement equipement;

	public static void main(String[] args) {
		
		
		logInScreen = new LogInScreen();
		inventory = new Inventory();
		equipement = new Equipement();
		scene=new Scene();
	
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		//frame.setContentPane(scene);
	
	}
	
	public static void changeScreentoLoading() {
		LoadingScreen ld = new LoadingScreen();
		ld.setLayout(null);
		ld.ps.setBounds(150,480,500,30);
		
		ld.label.setFont(new Font("LucidaSans", Font.PLAIN, 20));
		ld.label.setBounds(350,250,200,30);
		Thread t = new Thread(){
	        public void run(){

	            for(int i = 0 ; i <= 100 ; i++){
	                final int percent = i;
	                SwingUtilities.invokeLater(new Runnable() {
	                    public void run() {
	                        ld.ps.setValue(percent);
	                        if(percent >= 100) {
	                        	changeScreentoScene();
	                        	
	                        	if(Main.scene.hero.isVivant() == false) {
	                        		if(Main.scene.tabEnemi.size() == 0) {
	                        			Main.scene.hero.setHealth(90 + (Main.scene.hero.getHealthLvl()*10)+Main.scene.golem.getDmg());
	                        		} else {
		                        		Main.scene.hero.setHealth(90 + (Main.scene.hero.getHealthLvl()*10)+Main.scene.tabEnemi.get(1).getDmg());

	                        		}
	                        		Main.scene.hero.setVivant(true);
	                        		Main.scene.hero.setEnCombat(false);
	                        		Main.scene.hero.setLibre(true);
	                        		Main.scene.hero.setMarche(true);
	                        		
	                        		Main.scene.setStage(Main.scene.getStage() - 1);
	                        		Main.scene.hero.setStageMax(Main.scene.hero.getStageMax() - 1);
	                        		
	                        		if(Main.scene.stage != 10) {
		                        		Main.scene.setMonster();
	                        		} else {
		                        		Main.scene.setGolem();
	                        		}

	                        		changeToStats();

	                        		if(Main.scene.getStage() == 0) {
	                        			Main.scene.setStage(1);
	                        		} 
	                        		if(Main.scene.hero.getStageMax() == 0) {
	                        			Main.scene.hero.setStageMax(1);
	                        		}
	                        		if(Main.scene.stage <= 10) {
	                        			Main.scene.setIcoFond1(new ImageIcon(getClass().getResource("/images/stageForest.png")));
	        							Main.scene.setImgFond1(Main.scene.getIcoFond1().getImage());
	        							Main.scene.setImgFond2(Main.scene.getIcoFond1().getImage());	
	                        		} else if(Main.scene.stage > 10) {
	                        			Main.scene.setIcoFond1(new ImageIcon(getClass().getResource("/images/stageLava.png")));
	        							Main.scene.setImgFond1(Main.scene.getIcoFond1().getImage());
	        							Main.scene.setImgFond2(Main.scene.getIcoFond1().getImage());	
	                        		} 
	                        		                   		
	                        		Main.scene.setxPos(-1);
	                        	}
	                        }
	                    }
	                  });

	                try {
	                    Thread.sleep(5);
	                } catch (InterruptedException e) {}
	            }
	          
	        }
	        
	    };

	    frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
	    frame.setContentPane(ld);
		frame.revalidate();
		frame.repaint();
		t.start();
	
	}
	
	public static void changeScreentoScene() {
		
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		frame.setContentPane(Main.scene);
		Main.scene.add(Main.scene.upgrade.btnHealth);
		Main.scene.add(Main.scene.upgrade.btnHealthRegen);
		Main.scene.add(Main.scene.upgrade.btnDefence);
		Main.scene.add(Main.scene.upgrade.btnDmg);
		Main.scene.add(Main.scene.upgrade.btnCritChance);
		Main.scene.add(Main.scene.upgrade.btnCritDmg);
		Main.scene.add(Main.scene.upgrade.btnSave);
		Main.scene.add(Main.scene.upgrade.btnStats);
		Main.scene.add(Main.scene.upgrade.btnFarm);
		Main.scene.add(Main.scene.upgrade.btnRelic);
		Main.scene.add(Main.scene.upgrade.btnInventory);
		Main.scene.add(Main.scene.upgrade.btnEquipement);

		frame.revalidate();
		frame.repaint();

	}
	
	public static void changeToFarm() {
		heroFarm=new HeroFarm();
		
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		frame.setContentPane(heroFarm);
		frame.revalidate();
		frame.repaint();
	}
	
	public static void changeToStats() {
		if(Main.scene.stats == false) {
			Main.scene.upgrade.btnDmg.setVisible(false);
			Main.scene.upgrade.btnHealth.setVisible(false);
			Main.scene.upgrade.btnDefence.setVisible(false);
			Main.scene.upgrade.btnSave.setVisible(false);
			Main.scene.upgrade.btnHealthRegen.setVisible(false);
			Main.scene.upgrade.btnCritChance.setVisible(false);
			Main.scene.upgrade.btnCritDmg.setVisible(false);
		
		} else {
			Main.scene.upgrade.btnDmg.setVisible(true);
			Main.scene.upgrade.btnHealth.setVisible(true);
			Main.scene.upgrade.btnDefence.setVisible(true);
			Main.scene.upgrade.btnSave.setVisible(true);
			Main.scene.upgrade.btnHealthRegen.setVisible(true);
			Main.scene.upgrade.btnCritChance.setVisible(true);
			Main.scene.upgrade.btnCritDmg.setVisible(true);
		}

	}
	
	

}
