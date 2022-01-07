package com.hakim.logIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hakim.LogInScreen;
import com.hakim.Main;
import com.hakim.Profil;


@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	JLabel labelEmail;
	JTextField inputEmail;
	
	JLabel labelPassword;
	JTextField inputPassword;
	
	JButton btnConnection;
	public JButton btnCreateAccount;
	
	CreateAccountPanel createAccountPanel;
	
	Profil profil;
	LogIn logIn;
	
	public boolean loginBoolean;
	
	public LoginPanel() {
		labelEmail = new JLabel("Email");
		inputEmail = new JTextField(10);
		
		labelPassword = new JLabel("Password");
		inputPassword = new JTextField(10);
		
		btnConnection = new JButton("Connection");
		btnCreateAccount = new JButton("Create Account");
		
		this.add(labelEmail);
		this.add(inputEmail);
		
		this.add(labelPassword);
		this.add(inputPassword);
		
		this.add(btnConnection);
		this.add(btnCreateAccount);
		
	
		btnCreateAccount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LogInScreen.createAccountPanel=new CreateAccountPanel();
				
				LogInScreen.frameLogin.getContentPane().removeAll();
				LogInScreen.frameLogin.getContentPane().invalidate();
				
				LogInScreen.frameLogin.setContentPane(LogInScreen.createAccountPanel);
				LogInScreen.frameLogin.revalidate();
				LogInScreen.frameLogin.repaint();
			}
			
		});
		
		btnConnection.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = inputEmail.getText();
				String password = inputPassword.getText();
				
				
				logIn = new LogIn();
				profil = new Profil(email, password);	
				try {
					logIn.getAccount(profil);
					if(logIn.getAccount(profil) == true) {
						Main.frame.setVisible(true);
						LogInScreen.frameLogin.setVisible(false);
						//Main.scene.stage = profil.getStage();
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
	}
	
	
	
}
