package com.hakim.logIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hakim.LogInScreen;
import com.hakim.Main;
import com.hakim.Profil;
import com.hakim.SelecteHeroScreen;



@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	JLabel labelEmail;
	JTextField inputEmail;
	
	JLabel labelPassword;
	JPasswordField inputPassword;
	
	JButton btnConnection;
	public JButton btnCreateAccount;
	
	JLabel labelErrorMsg;
	
	CreateAccountPanel createAccountPanel;
	
	public static int minuteOutOfGame;
	
	public Profil profil;
	LogIn logIn;
	
	public boolean loginBoolean;
	
	public LoginPanel() {
		
		this.setLayout(null);
		labelEmail = new JLabel("Email");
		labelEmail.setBounds(60, 40, 200, 30);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(180, 40, 200, 30);
		inputEmail.setBorder(BorderFactory.createCompoundBorder(inputEmail.getBorder(),BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		labelPassword = new JLabel("Password");
		labelPassword.setBounds(60, 90, 200, 30);
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(180, 90, 200, 30);
		inputPassword.setBorder(BorderFactory.createCompoundBorder(inputEmail.getBorder(),BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		labelErrorMsg = new JLabel("");
		labelErrorMsg.setBounds(100, 150, 250, 30);
		
		btnConnection = new JButton("Connection");
		btnConnection.setBounds(60, 200, 100, 30);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(220, 200, 150, 30);

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
				@SuppressWarnings("deprecation")
				String password = inputPassword.getText();
				
				
				logIn = new LogIn();
				profil = new Profil(email, password);	
				try {
					logIn.getAccount(profil);
					if(logIn.getAccount(profil) == true) {
						if(Main.scene.hero.getSelectedHero() != null) {
							
							Main.frame.add(Main.scene);
							Main.frame.setVisible(true);
							
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
								labelErrorMsg.setText("<html><p style='color:red;'>L'?mail ou le mot de passe sont incorrecte</p></html>");
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
