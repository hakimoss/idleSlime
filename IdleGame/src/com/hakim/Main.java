package com.hakim;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.hakim.gameplay.Upgrade;
import com.hakim.logIn.LogIn;
import com.hakim.logIn.LoginPanel;

public class Main {
	
	public static Scene scene;
	public static HeroFarm heroFarm;
	public static LogInScreen logInScreen;
	public static JFrame frame;

	public static void main(String[] args) {
		LoginPanel lp=new LoginPanel();
		logInScreen = new LogInScreen();
		scene=new Scene();
		
			
			
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		
		
		
		
		
		
		
		
		frame.setContentPane(scene);
	
		
			
			
		
		
		
		/*
		Profil p = new Profil("hakimos123@live.ca", "123soleil456", "hakimos321");
		LogIn l=new LogIn();
		System.out.println(l.CheckEmailExists("hakimos321321@live.ca"));
		*/
		
		/*
		LogIn l=new LogIn();
		Profil p = new Profil("hakimos123@live.ca", "123soleil456", "hakimos321");
		
		try {
			
			System.out.println(l.getAccount(p));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
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
	                        		Main.scene.hero.setHealth(100 + ((Main.scene.hero.getHealthLvl()-1)*20));
	                        		Main.scene.hero.setVivant(true);
	                        		Main.scene.hero.setEnCombat(false);
	                        		Main.scene.hero.setLibre(true);
	                        		Main.scene.hero.setMarche(true);
	                        		
	                        		Main.scene.setStage(Main.scene.getStage() - 1);
	                        		Main.scene.setMonster();
	                        		
	                        		Main.scene.upgrade = new Upgrade(Main.scene.hero);
	                        		
	                        		Main.scene.upgrade.btnDmg.setBounds(30, 500, 100, 20);
	                        		Main.scene.upgrade.btnHealth.setBounds(150, 500, 100, 20);
	                        		Main.scene.upgrade.btnHeroFarm.setBounds(270, 500, 100, 20);
	                        		
	                        		Main.scene.add(Main.scene.upgrade.btnHealth);
	                        		Main.scene.add(Main.scene.upgrade.btnDmg);
	                        		Main.scene.add(Main.scene.upgrade.btnHeroFarm);
                      		
	                        		if(Main.scene.getStage() == 0) {
	                        			Main.scene.setStage(1);
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
		Main.scene.add(Main.scene.upgrade.btnDmg);
		Main.scene.add(Main.scene.upgrade.btnHeroFarm);

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
	
	

}
