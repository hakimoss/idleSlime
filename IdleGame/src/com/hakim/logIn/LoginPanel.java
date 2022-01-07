package com.hakim.logIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hakim.LogInScreen;
import com.hakim.Main;
import com.hakim.Profil;
import com.hakim.Scene;
import com.hakim.SelecteHeroScreen;



@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	JLabel labelEmail;
	JTextField inputEmail;
	
	JLabel labelPassword;
	JTextField inputPassword;
	
	JButton btnConnection;
	public JButton btnCreateAccount;
	
	JLabel labelErrorMsg;
	
	CreateAccountPanel createAccountPanel;
	
	public static int minuteOutOfGame;
	
	public Profil profil;
	LogIn logIn;
	
	public boolean loginBoolean;
	
	public LoginPanel() {
		labelEmail = new JLabel("Email");
		inputEmail = new JTextField(10);
		
		labelPassword = new JLabel("Password");
		inputPassword = new JTextField(10);
		
		btnConnection = new JButton("Connection");
		btnCreateAccount = new JButton("Create Account");
		
		labelErrorMsg = new JLabel("");
		
		this.add(labelEmail);
		this.add(inputEmail);
		
		this.add(labelPassword);
		this.add(inputPassword);
		
		this.add(btnConnection);
		this.add(btnCreateAccount);
		
		this.add(labelErrorMsg);
		
		
		
	
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
				Main.scene.hero.setProfil(profil);
				try {
					logIn.getAccount(profil);
					if(logIn.getAccount(profil) == true) {
						if(Main.scene.hero.getSelectedHero() != null) {
							
							Main.frame.add(Main.scene);
							Main.frame.setVisible(true);
							System.out.println("selected hero : "+Main.scene.hero.getSelectedHero());
							
							LogInScreen.frameLogin.setVisible(false);
							
							long start = Main.scene.hero.getLastUpdate();
							// some time passes
							long end = System.currentTimeMillis();
							long elapsedTime = end - start;
							minuteOutOfGame = (int) (elapsedTime / 1000) / 60;
							if(minuteOutOfGame > 120) {
								minuteOutOfGame = 120;
							}
							Main.scene.hero.setGold(Main.scene.hero.getGold() + (minuteOutOfGame * Main.scene.hero.getStageMax()));
							//Main.scene.stage = profil.getStage();
							if(Main.scene.hero.getStageMax() > 10) {
								Main.scene.setIcoFond1(new ImageIcon(getClass().getResource("/images/stageLava.png")));
								Main.scene.setImgFond1(Main.scene.getIcoFond1().getImage());
								Main.scene.setImgFond2(Main.scene.getIcoFond1().getImage());
							}
						} else {
							SelecteHeroScreen selectedHeroScreen = new SelecteHeroScreen();
							Main.frame.add(selectedHeroScreen);
							Main.frame.setVisible(true);
							
							LogInScreen.frameLogin.dispose();
						
							
						}
						
					} else {
						new Thread(new Runnable()
						{
						    @Override
						    public void run()
						    {
								labelErrorMsg.setText("<html><p style='color:red;'>L'�mail ou le mot de passe sont incorrecte</p></html>");
						        try {
									Thread.sleep(4000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}      
								labelErrorMsg.setText("");
						    }
						}).start();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
	}

	
	
}