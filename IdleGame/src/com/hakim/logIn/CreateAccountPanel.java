package com.hakim.logIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hakim.LogInScreen;
import com.hakim.Profil;

@SuppressWarnings("serial")
public class CreateAccountPanel extends JPanel {
	JLabel labelErrorMsg;
	
	JLabel labelEmail;
	JTextField inputEmail;
	
	JLabel labelPassword;
	JPasswordField inputPassword;
	
	JLabel labelName;
	JTextField inputName;
	
	JButton btnCreate;
	public JButton btnConnectionScreen;
	
	private static final String EMAIL_PATTERN = 
		    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	
	public CreateAccountPanel() {
		this.setLayout(null);
		
		
		
		labelEmail = new JLabel("Email");
		labelEmail.setBounds(60, 20, 200, 30);
		
		inputEmail = new JTextField();
		inputEmail.setBounds(180, 20, 200, 30);
		inputEmail.setBorder(BorderFactory.createCompoundBorder(inputEmail.getBorder(),BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		labelPassword = new JLabel("Password");
		labelPassword.setBounds(60, 70, 200, 30);
		
		inputPassword = new JPasswordField();
		inputPassword.setBounds(180, 70, 200, 30);
		inputPassword.setBorder(BorderFactory.createCompoundBorder(inputEmail.getBorder(),BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		labelName = new JLabel("Name");
		labelName.setBounds(60, 120, 200, 30);
		inputName = new JTextField();
		inputName.setBounds(180, 120, 200, 30);
		inputName.setBorder(BorderFactory.createCompoundBorder(inputEmail.getBorder(),BorderFactory.createEmptyBorder(0, 5, 0, 5)));
		
		labelErrorMsg = new JLabel("");
		labelErrorMsg.setBounds(150, 160, 200, 30);
		
		btnCreate = new JButton("Create");
		btnCreate.setBounds(60, 200, 100, 30);

		btnConnectionScreen = new JButton("Already have account ?");
		btnConnectionScreen.setBounds(220, 200, 150, 30);

		
		
		this.add(labelEmail);
		this.add(inputEmail);
		
		this.add(labelPassword);
		this.add(inputPassword);
		
		this.add(labelName);
		this.add(inputName);
		
		this.add(btnCreate);
		this.add(btnConnectionScreen);
		
		this.add(labelErrorMsg);

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

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String email = inputEmail.getText();
				String password = inputPassword.getText();
				String name = inputName.getText();
				
				Profil p = new Profil(email, password, name);
				LogIn l = new LogIn();
				
				
				if(l.CheckEmailExists(email) == true) {
					new Thread(new Runnable()
					{
					    @Override
					    public void run()
					    {
							labelErrorMsg.setText("<html><p style='color:red;'>L'?mail existe d?ja...</p></html>");
					        try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}      
							labelErrorMsg.setText("");
					    }
					}).start();		
				} else if (!email.matches(EMAIL_PATTERN)) {
					new Thread(new Runnable()
					{
					    @Override
					    public void run()
					    {
							labelErrorMsg.setText("<html><p style='color:red;'>Veuillez inscrire un email valide</p></html>");
					        try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}      
							labelErrorMsg.setText("");
					    }
					}).start();
				} else if(inputPassword.getText().equals("")) {
					new Thread(new Runnable()
					{
					    @Override
					    public void run()
					    {
							labelErrorMsg.setText("<html><p style='color:red;'>Veuillez inscrire un mot de passe</p></html>");
					        try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}      
							labelErrorMsg.setText("");
					    }
					}).start();
				} else if (inputName.getText().equals("")) {
					new Thread(new Runnable()
					{
					    @Override
					    public void run()
					    {
							labelErrorMsg.setText("<html><p style='color:red;'>Veuillez inscrire un nom</p></html>");
					        try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}      
							labelErrorMsg.setText("");
					    }
					}).start();
				} else {
					l.createAccount(p);
					
					LogInScreen.loginPanel=new LoginPanel();
					
					LogInScreen.frameLogin.getContentPane().removeAll();
					LogInScreen.frameLogin.getContentPane().invalidate();
					
					LogInScreen.frameLogin.setContentPane(LogInScreen.loginPanel);
					LogInScreen.frameLogin.revalidate();
					LogInScreen.frameLogin.repaint();
				}
				
				
			}
			
		});
	}
	
	
}
