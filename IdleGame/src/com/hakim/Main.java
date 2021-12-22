package com.hakim;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;
	public static MenuScene menuScene;

	public static void main(String[] args) {


		
		
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		scene=new Scene();
		menuScene=new MenuScene();
		
		frame.setContentPane(scene);
		//frame.setContentPane(menuScene);
		frame.setVisible(true);

		
		
	}

}
