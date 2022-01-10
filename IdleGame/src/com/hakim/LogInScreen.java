package com.hakim;



import javax.swing.JFrame;

import com.hakim.logIn.CreateAccountPanel;
import com.hakim.logIn.LoginPanel;

public class LogInScreen{
	public static LoginPanel loginPanel;
	public static CreateAccountPanel createAccountPanel;
	public static JFrame frameLogin;
	
	public LogInScreen() {
		frameLogin = new JFrame();		
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setSize(460, 300);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.setResizable(false);
		frameLogin.setAlwaysOnTop(true);
		
		loginPanel=new LoginPanel();
		
		
		frameLogin.setContentPane(loginPanel);
		frameLogin.setVisible(true);		
	}
	

}

