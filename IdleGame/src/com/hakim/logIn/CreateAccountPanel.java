package com.hakim.logIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hakim.LogInScreen;
import com.hakim.Profil;

@SuppressWarnings("serial")
public class CreateAccountPanel extends JPanel {
	JLabel labelEmail;
	JTextField inputEmail;
	
	JLabel labelPassword;
	JTextField inputPassword;
	
	JLabel labelName;
	JTextField inputName;
	
	JButton btnCreate;
	public JButton btnConnectionScreen;

	
	public CreateAccountPanel() {
		labelEmail = new JLabel("Email");
		inputEmail = new JTextField(10);
		
		labelPassword = new JLabel("Password");
		inputPassword = new JTextField(10);
		
		labelName = new JLabel("Name");
		inputName = new JTextField(10);
		
		btnCreate = new JButton("Create");
		btnConnectionScreen = new JButton("Already have account ?");

		
		this.add(labelEmail);
		this.add(inputEmail);
		
		this.add(labelPassword);
		this.add(inputPassword);
		
		this.add(labelName);
		this.add(inputName);
		
		this.add(btnCreate);
		this.add(btnConnectionScreen);

		btnConnectionScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LogInScreen.loginPanel=new LoginPanel();
				
				LogInScreen.frameLogin.getContentPane().removeAll();
				LogInScreen.frameLogin.getContentPane().invalidate();
				
				LogInScreen.frameLogin.setContentPane(LogInScreen.loginPanel);
				LogInScreen.frameLogin.revalidate();
				LogInScreen.frameLogin.repaint();
			}
			
		});
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String email = inputEmail.getText();
				String password = inputPassword.getText();
				String name = inputName.getText();
				
				
				
				Profil p = new Profil(email, password, name);
				LogIn l = new LogIn();
				
				if(l.CheckEmailExists(email) == true) {
					JOptionPane.showMessageDialog(null, "L'email existe deja");
				} else {
					JOptionPane.showMessageDialog(null, "Le compte a �t� cr�e avec succes");
					l.createAccount(p);
				}
				
				
			}
			
		});
	}
	
	
}
