package com.hakim.personnages;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemi extends Personnages implements Runnable{

	private Image imgEnemi;
	private ImageIcon icoEnemi;
	private int dxEnemi;
	private final int PAUSE = 15;
	
	public Enemi(int x, int y) {
		super(x, y, 25, 32);
		super.setVersDroite(false);
		super.setMarche(true);
		this.dxEnemi = 1;
		
		icoEnemi = new ImageIcon(getClass().getResource("/images/enemi1Gauche.png"));
		imgEnemi = icoEnemi.getImage();
	
	}

	//   GETTERS   //
	public Image getImgEnemi() {return imgEnemi;}
	
	//   METHODS   //
	public void bouge() {
		if(super.isVersDroite() == true) {
			this.dxEnemi = 1;
		} else {
			this.dxEnemi = -1;
		}
		super.setX(super.getX() + this.dxEnemi);
	}
	

	public void contact(Personnages personnage) {
		
		if(super.contactArriere(personnage) || super.contactAvant(personnage) ) {
			Thread thread = new Thread(this);
			thread.start();
	
		} 	
	}

	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVivant(false);
		
	}





	

}