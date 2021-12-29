package com.hakim;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class LoadingScreen extends JPanel {

	JLabel label;
	JProgressBar ps;
	
	LoadingScreen() {
		label = new JLabel("Loading ...");
		ps = new JProgressBar(0, 100);
		ps.setStringPainted(true);
		this.add(label);
		this.add(ps);
		
		
		
	}
}
