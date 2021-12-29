package com.hakim;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	public static Scene scene;
	
	private static JFrame frame;
	
	//private static LoadingScreen ld;
	
	public static boolean loading = false;
	

	public static void main(String[] args) {

		
		
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		
		scene=new Scene();
		frame.setContentPane(scene);
		

		frame.setVisible(true);	
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
	                        		Main.scene.hero.setHealth(10 + ((Main.scene.hero.getHealthLvl()-1)*20));
	                        		Main.scene.hero.setVivant(true);
	                        		Main.scene.hero.setEnCombat(false);
	                        		Main.scene.hero.setLibre(true);
	                        		
	                        		Main.scene.setStage(Main.scene.getStage() - 1);
	                        		Main.scene.setMonster();
	                        		
	                        		Main.scene.upgrade = new Upgrade(Main.scene.hero);
	                        		
	                        		Main.scene.upgrade.btnDmg.setBounds(30, 500, 100, 20);
	                        		Main.scene.upgrade.btnHealth.setBounds(150, 500, 100, 20);
	                        		
	                        		Main.scene.add(Main.scene.upgrade.btnHealth);
	                        		Main.scene.add(Main.scene.upgrade.btnDmg);
	                        		
	                        		if(Main.scene.getStage() == 0) {
	                        			Main.scene.setStage(1);
	                        		}
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
		//frame.getContentPane().removeAll();
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		
		frame.setContentPane(scene);
		frame.revalidate();
		frame.repaint();

	}
	
	

}
